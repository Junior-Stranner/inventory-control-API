// Função para alternar o "dark mode" e "light mode"
function toggleDarkMode() {
    const body = document.body;
    const moonIcon = document.querySelector(".fa-moon");
    const sunIcon = document.querySelector(".fa-sun");

    if (body.classList.contains("dark-mode")) {
        // Desativa o dark mode
        body.classList.remove("dark-mode");
        moonIcon.style.display = "block";
        sunIcon.style.display = "none";
        localStorage.setItem("darkMode", "disabled");
    } else {
        // Ativa o dark mode
        body.classList.add("dark-mode");
        moonIcon.style.display = "none";
        sunIcon.style.display = "block";
        localStorage.setItem("darkMode", "enabled");
    }
}

// Função para verificar o estado do "dark mode" no carregamento da página
function checkDarkMode() {
    const body = document.body;
    const moonIcon = document.querySelector(".fa-moon");
    const sunIcon = document.querySelector(".fa-sun");

    if (localStorage.getItem("darkMode") === "enabled") {
        // Ativa o dark mode no carregamento da página
        body.classList.add("dark-mode");
        moonIcon.style.display = "none";
        sunIcon.style.display = "block";
    }
}

// Adicione um evento de clique ao ícone da lua para alternar o "dark mode"
document.querySelector(".fa-moon").addEventListener("click", toggleDarkMode);

// Verifique o estado do "dark mode" no carregamento da página
checkDarkMode();
