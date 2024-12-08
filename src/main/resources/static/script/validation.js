const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');
const btnPopup = document.querySelector('.btnLogin-popup');
const iconClose = document.querySelector('.icon-close');
const loginBtn = document.getElementById('loginBtn');
const registerBtn = document.getElementById('registerBtn');

// Automatically trigger popup on page load
document.addEventListener('DOMContentLoaded', () => {
    wrapper.classList.add('active-popup');
});

// Trigger popup when clicking anywhere on the page
document.addEventListener('click', () => {
    wrapper.classList.add('active-popup');
});

registerLink.addEventListener('click', () => {
    wrapper.classList.add('active');
});

loginLink.addEventListener('click', () => {
    wrapper.classList.remove('active');
});

iconClose.addEventListener('click', () => {
    wrapper.classList.remove('active-popup');
});



loginBtn.addEventListener('click', (event) => {
    window.location.href = 'profile.html';  // Redirect to the profile page
});

registerBtn.addEventListener('click', (event) => {
    window.location.href = 'profile.html';  // Redirect to the profile page
});