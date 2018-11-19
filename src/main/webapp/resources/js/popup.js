$(document).ready(function() {
	$('body').append('<div id="popUp"></div>');
	$('#popUp').append('<div id="promoForm"></div>')
	

	$('body').on('click','.card-middle-button',function(){
		$('#promoForm').empty();
		$('#promoForm').append(`
		  		<div class="card card-box">
		    		<img class="card-img-top card-middle card-image" src="img/1.png" alt="Card image cap">
		    		<div class="card-block">
		      			<h4 class="card-title card-middle-text">Магазин</h4>
		      			<p class="card-text">Длинное описание промокода</p>
		      			<p class="card-text"><small class="text-muted">был добавлен 1 января 1970 года</small></p>
		      			<a href="#" class="btn btn-primary card-middle-button">${$(this).val()}</a>
		      			<div class="row feedback" >
		      			  <div class="col-sm-1">	</div>
						  <div class="col-sm-3">
						    <div class="card" id="like">
						      <div class="card-body" title="Понравилось">
						        
						        <p class="card-text">
						        		<i class="fa fa-thumbs-up"></i>
						        </p>
						        <p class="smileDescription">	Like</p>
						        
						      </div>
						    </div>
						  </div>
						  <div class="col-sm-3">
						    <div class="card" id="dislike">
						      <div class="card-body" >
						        
						        <p class="card-text">
						        		<i class="fa fa-thumbs-down"></i>
						        </p>
						        <p class="smileDescription">	Dislike</p>
						      </div>
						    </div>
						  </div>
						  <div class="col-sm-3">
						    <div class="card" id="not-working">
						      <div class="card-body" >
						        
						        <p class="card-text"><i class="fa fa-frown-o" aria-hidden="true"></i></p>
						        <p class="smileDescription">	Не работает</p>
						      </div>
						    </div>
						  </div>
						  
						  
						</div>

						<div class="comments">	
								<div class="row comments-row">	
										<div class="col-md-2">	
												<i id="userPic" class="fa fa-user"></i>
										</div>
										<div class="col-md-10">	
												<p>	login</p>
												<p>	comment</p>
										</div>
								</div>

								

								<div class="comment row comments-row">	
										<textarea id='message'></textarea>
										<button style="width:20%"class="btn btn-info">Отправить</button>
								</div>
						</div>
		    		</div>
		  		</div>
	  		`);
		$('#popUp').css('display','flex');
		$('#promoForm').animate({opacity:1},500);
		$('body').css('overflow','hidden')
	})

	$('body').on('click','#popUp',function(e){
		if (e.target !== this)
    		return;
		$('#promoForm').animate({opacity:0},400,function(){
			$('#popUp').css('display','none');
			$('body').css('overflow','auto')
		});
		
		
	})

	$('body').on('click','#like,#dislike,#not-working',function(){
			let activeClass = `${$(this).prop('id')}-active`;
			console.log(activeClass)
			if( $(this).hasClass(`${activeClass}`)){
					$(this).removeClass(activeClass);
			} else {
				$('#like').removeClass('like-active');
				$('#dislike').removeClass('dislike-active');
				$('#not-working').removeClass('not-working-active');
				$(this).addClass(activeClass)

			}
	})



})