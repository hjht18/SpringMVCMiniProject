
jQuery(document).ready(function(){

    $('.imgslide a:gt(0)').hide();
        setInterval(function(){
         $('.imgslide a:first-child').fadeOut()
         .next('a').fadeIn()
         .end().appendTo('.imgslide');}, 3000);
		});

         const toggleBtn = document.querySelector('.toggleBtn');
         const menu = document.querySelector('.navi');
         const icons = document.querySelector('.cartlogo')

         toggleBtn.addEventListener('click', () =>{
            menu.classList.toggle('active');
            icons.classList.toggle('active');
});