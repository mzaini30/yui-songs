$('.top').click(function(){
	$('html, body').animate({
		scrollTop: 0
	}, 700)
})

$(".cari").on("keyup", function() {
	var value = $(this).val().toLowerCase();
	$(".song").filter(function() {
		$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	});
});

// var pTags = $( "p" );
// $( "button" ).click(function() {
//   if ( pTags.parent().is( "div" ) ) {
//     pTags.unwrap();
//   } else {
//     pTags.wrap( "<div></div>" );
//   }
// });

$('.list-group-item').each(function(){
	$(this).click(function(){
		$('.list-group-item marquee span').unwrap()
		$(this).find('span').wrap('<marquee></marquee>')
		AndAud.stopAudio()
		AndAud.playAudio('yui/' + $(this).data('lagu'))
		// $('title').html('sabyan/' + $(this).data('lagu') + '.mp3')
	})
})