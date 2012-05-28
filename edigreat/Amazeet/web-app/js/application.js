if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(document).ready(function(){
        var ancho = 600;
        var alto = 250;
       $(document).on("click", "#button", function(){ 
      //  $('#button').click(function(){

       $.ajax({
                  type: "POST",
                  url: "/Amazeet/store/showShoppingCart",
                  success: function(datos){
                  var contenidoHTML = '';
                  contenidoHTML = contenidoHTML + datos;
                  var bgdiv        = $('<div>').attr({
                                        class: 'bgtransparent',
                                        id: 'bgtransparent'
                                        });
              
                $(bgdiv).fadeIn(1000);
                $(bgdiv).fadeTo("slow",0.6);

                $('body').append(bgdiv);

                var wscr = $(window).width();
                var hscr = $(window).height();

                $('#bgtransparent').css("width", wscr);
                $('#bgtransparent').css("height", hscr);

                var moddiv = $('<div>').attr({
                                        class: 'bgmodal',
                                        id: 'bgmodal'
                                        });

                 $(moddiv).fadeIn(1500);

                 
                $('body').append(moddiv);

                $('#bgmodal').append(contenidoHTML);

                $(window).resize();
            
                }
            });  


        });

        $(window).resize(function(){
                var wscr = $(window).width();
                var hscr = $(window).height();

                $('#bgtransparent').css("width", wscr);
                $('#bgtransparent').css("height", hscr);

                $('#bgmodal').css("width", ancho+'px');
                $('#bgmodal').css("height", alto+'px');

                var wcnt = $('#bgmodal').width();
                var hcnt = $('#bgmodal').height();

                var mleft = ( wscr - wcnt ) / 2;
                var mtop = ( hscr - hcnt ) / 2;

                $('#bgmodal').css("left", mleft+'px');
                $('#bgmodal').css("top", mtop+'px');


        });

 });

function closeModal(){

        $('#bgmodal').remove();
        $('#bgtransparent').remove();
}
