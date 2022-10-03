const slideContainer = document.querySelector('.slide-container');
const nextBtn = document.querySelector('.slide-next');
const prevBtn = document.querySelector('.slide-prev');
let photo = 2;

nextBtn.addEventListener('click', function () {
  if (photo < 2) {
    slideContainer.style.transform = `translateX(0vw)`;
    photo = 2;
  } else {
    slideContainer.style.transform = `translateX(-100vw)`;
    photo = 1;
  }
});

prevBtn.addEventListener('click', function () {
  if (photo > 1) {
    slideContainer.style.transform = `translateX(-100vw)`;
    photo = 1;
  } else {
    slideContainer.style.transform = `translateX(0vw)`;
    photo = 2;
  }
});
