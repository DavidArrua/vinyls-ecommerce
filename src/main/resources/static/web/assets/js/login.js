const app = Vue.createApp({
  data() {
      return {
          email: "",
          pwd: "",
          firstName: "",
          lastName: "",
      };
  },
  created() { },
  methods: {
      login() {
          axios
              .post("/api/login", `email=${this.email}&pwd=${this.pwd}`, {
                  headers: { "content-type": "application/x-www-form-urlencoded" },
              })
              .then((response) => (location.href = "/web/index.html"))
              .catch((response) => 
              Swal.fire({
                icon: 'error',
                title: 'Algo salio mal!',
                color: '#ffd22afe',
                text: 'Por favor verifica todos los campos'

            })
            );
      },

      register() {
          axios
              .post(
                  "/api/clients",
                  `firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.pwd}`,
                  { headers: { "content-type": "application/x-www-form-urlencoded" } }
              )
              .then((response) => (location.href = "/web/index.html"))
              .catch((error) => 
              Swal.fire({
                icon: 'error',
                title: 'Algo salio mal!',
                color: '#ffd22afe',
                text: `${error.response.data}`,
              
                
            }))
     
      },
  },
}).mount("#app");
  












(function ($) {
    
    // Ripple-effect animation
    $(".ripple-effect").click(function (e) {
        var rippler = $(this);

      	rippler.append("<span class='ink'></span>");

        var ink = rippler.find(".ink:last-child");
        // prevent quick double clicks
        ink.removeClass("animate");

        // set .ink diametr
        if (!ink.height() && !ink.width()) {
            var d = Math.max(rippler.outerWidth(), rippler.outerHeight());
            ink.css({
                height: d,
                width: d
            });
        }

        // get click coordinates
        var x = e.pageX - rippler.offset().left - ink.width() / 2;
        var y = e.pageY - rippler.offset().top - ink.height() / 2;

        // set .ink position and add class .animate
        ink.css({
            top: y + 'px',
            left: x + 'px'
        }).addClass("animate");
        
        // remove ink after 1second from parent container
        setTimeout(function(){
        	ink.remove();
        },400)
    })



// Ripple-effect-All animation
   function fullRipper(color,time){
       setTimeout(function(){
            var rippler = $(".ripple-effect-All");
            if(rippler.find(".ink-All").length == 0){
                rippler.append("<span class='ink-All'></span>");
                

                var ink = rippler.find(".ink-All");
                // prevent quick double clicks
                //ink.removeClass("animate");

                // set .ink diametr
                if (!ink.height() && !ink.width()) {
                    var d = Math.max(rippler.outerWidth(), rippler.outerHeight());
                    ink.css({
                        height: d,
                        width: d
                    });
                }

                // get click coordinates
                var x =0;
                var y =rippler.offset().top - ink.height()/1.5;

                // set .ink position and add class .animate
                ink.css({
                    top: y + 'px',
                    left: x + 'px',
                    background:color
                }).addClass("animate");

                rippler.css('z-index',2);

                setTimeout(function(){
                    ink.css({
                        '-webkit-transform': 'scale(2.5)',
                        '-moz-transform': 'scale(2.5)',
                        '-ms-transform': 'scale(2.5)',
                        '-o-transform': 'scale(2.5)',
                        'transform': 'scale(2.5)'
                    })
                    rippler.css('z-index',0);
                },1500);
            }
       },time)
        
    }

    // Form control border-bottom line
    $('.blmd-line .form-control').bind('focus',function(){
        $(this).parent('.blmd-line').addClass('blmd-toggled').removeClass("hf");
    }).bind('blur',function(){
        var val=$(this).val();
        if(val){
            $(this).parent('.blmd-line').addClass("hf");
        }else{
            $(this).parent('.blmd-line').removeClass('blmd-toggled');
        }
    })

    // Change forms
    $(".blmd-switch-button").click(function(){
        var _this=$(this);
        if(_this.hasClass('active')){
            setTimeout(function(){
                _this.removeClass('active');
                $(".ripple-effect-All").find(".ink-All").remove();
                $(".ripple-effect-All").css('z-index',0);
            },1300);
            $(".ripple-effect-All").find(".ink-All").css({
                '-webkit-transform': 'scale(0)',
                '-moz-transform': 'scale(0)',
                '-ms-transform': 'scale(0)',
                '-o-transform': 'scale(0)',
                'transform': 'scale(0)',
                'transition':'all 1.5s'
            })
            $(".ripple-effect-All").css('z-index',2);
            $('#Register-form').addClass('form-hidden')
            .removeClass('animate');
            $('#login-form').removeClass('form-hidden');
        }else{
            fullRipper("#26a69a",750);
            _this.addClass('active');
            setTimeout(function(){
                $('#Register-form').removeClass('form-hidden')
                .addClass('animate');
                $('#login-form').addClass('form-hidden');
            },2000)
            
        }
    })
})(jQuery);

/************************ VALIDADOR DE CONTRASEÑA ************************************/
var validatePassword = function (elem) {
    var validationRules = [
      "quantity",
      "lowerCase",
      "upperCase",
      "numbers",
      "specialCharacters",
    ];
    var validationRules2 = [
      {
        name: "quantity",
        test: "^.{8,}$"
      },
      {
        name: "lowerCase",
        test: "[a-z]"
      },
      {
        name: "upperCase",
        test: "[A-Z]"
      },
      {
        name: "numbers",
        test: "[0-9]"
      },
      {
        name: "specialCharacters",
        test: "[$#¿!%*?&]"
      },
    ];
    var _str = $(elem).val();
    for (i in validationRules2) {
      if (
        validationRules2[i].name != undefined 
      ) {
        var regEx = RegExp(validationRules2[i].test);
        var _out = regEx.exec(_str);
        if (_out != null)
          $("[data-validation='" + validationRules2[i].name + "']")
            .attr("checked", "checked")
            .parent()
            .addClass("work-compleate text-success");
        else
          $("[data-validation='" + validationRules2[i].name + "']")
            .removeAttr("checked", "checked")
            .parent()
            .removeClass("work-compleate text-success");
      } 
    }
  };
  
  var validarSecuencias = function (str, otra) {
    var $error = false;
    var secuencia = ["abcdefghijklmnopqrstuvwxyz", "1234567890"];
    if (otra != undefined) {
      secuencia.push(otra);
    }
  
    var text = str;
  
    var _text = text.toLowerCase();
    _text.split("");
    if (_text.length >= 8) {
      for (var count = 0; count < secuencia.length; count++) {
        var _secuencia = secuencia[count];
        _secuencia = _secuencia.split("");
  
        for (var i = 1; i < _text.length; i++) {
          var compA = _text[i - 1];
          var compB = _text[i];
  
          for (var j = 1; j < _secuencia.length; j++) {
            if (_secuencia[j - 1] == compA) {
              if (compB == _secuencia[j]) {
                $error = true;
              }
            }
          }
        }
      }
    } else {
      $error = true;
    }
    return $error;
  };
  
  $("#password").keyup(function () {
    validatePassword($(this));
  });
  
  var valPass = new validatePassword($("#password"));