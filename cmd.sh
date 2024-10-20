#!/bin/bash
set -e
script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" &>/dev/null && pwd)"
mkdir -p build

_z_1_setup_tools() {
    sdk env install
    nvm install
    nvm use
    pre-commit install
}

_z_2_setup_repo() {
    git submodule sync
    git submodule init
    git submodule update --recursive --remote
}

_z_3_setup_site() {
    cd semusings.dev
    npm install -g pnpm
    pnpm install
    cd ..
}

_z_4_run_site() {
    cd semusings.dev
    pnpm dev
    cd ..
}

##################################################################################
##################################################################################
z_function_names() {
  declare -F | awk '{print $3}' | grep -E '^_z_'
}

# Display menu and execute functions
show_menu() {
  echo "--------------------"
  PS3="Enter your choice: "
  options=($(z_function_names))
  select opt in "${options[@]}" "Exit"; do
    if [[ "$REPLY" -le ${#options[@]} && "$REPLY" -gt 0 ]]; then
      ${options[$((REPLY - 1))]}
      printf "\n"
      cd "$script_dir" && show_menu
    elif [[ "$REPLY" -eq $(( ${#options[@]} + 1 )) ]]; then
      echo "Exiting..."
      break
    else
      echo "Invalid choice! Please choose again."
    fi
  done
}

show_menu