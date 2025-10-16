/*!
* Start Bootstrap - Personal v1.0.1 (https://startbootstrap.com/template-overviews/personal)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-personal/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
document.addEventListener("DOMContentLoaded", () => {
    const buttons = document.querySelectorAll(".filter-btn");
    const cards = document.querySelectorAll(".project-card");

    if (buttons.length === 0 || cards.length === 0) {
        // Not on the Projects page, so skip
        return;
    }

    buttons.forEach(button => {
        button.addEventListener("click", () => {
            buttons.forEach(btn => btn.classList.remove("active"));
            button.classList.add("active");

            const filter = button.dataset.filter;
            console.log("Clicked:", filter);

            cards.forEach(card => {
                const category = card.dataset.category;
                card.style.display = (filter === "all" || category === filter)
                    ? "block"
                    : "none";
            });
        });
    });
});
