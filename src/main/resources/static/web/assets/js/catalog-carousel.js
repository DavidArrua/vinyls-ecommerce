window.addEventListener("load", function(){
  new Glider(document.querySelector(".carousel__list"),{
    slidesToShow: 1,
    slidesToScroll: 1,
    dots: '.caousel__indicadores',
    arrows: {
      prev: '.carousel__previous',
      next: '.carousel__next'
    },
    responsive: [
      {
        breakpoint: 450,
        settings: {
          slidesToShow: '2',
          slidesToScroll: '2'
        }
      },{
        breakpoint: 800,
        settings: {
          slidesToShow: 4,
          slidesToScroll: 4
        }
      }
    ]
  })
})