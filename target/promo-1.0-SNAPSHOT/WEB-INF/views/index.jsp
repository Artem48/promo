<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/header.jsp" />
<body>

<header class="slimHeader has-title" id="pageHeaderSlim">
    <div class="topBar">
        <div class="container"><button class="burger-btn" aria-label="Show menu" id="mainNavTrigger"><span class="burger-btn_box"><span class="burger-btn_inner"></span></span></button>
            <nav class="main-nav">
                <ul class="main-nav_list">
                    <li class="main-nav_item dropdown has-child"><a class="main-nav_link" id="shopDropdownTrigger" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Магазины
                    </a>
                        <div class="dropdown-menu main-nav_dropdown is-shop lazy-loader">
                            <div class="main-nav_header">

                            </div>
                            <ul class="brand-list" id="shopDropdown"></ul>
                        </div>
                    </li>
                    <li class="main-nav_item dropdown has-child"><a class="main-nav_link" href="" id="categoryDropdownTrigger" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Категории
                    </a>
                        <ul class="dropdown-menu main-nav_dropdown is-category lazy-loader" id="categoryDropdown"></ul>
                    </li>
                    <li class="main-nav_item "><a href="/" class="main-nav_link ">
                        Топ-50
                    </a></li>



                </ul>
            </nav><span class="main-nav_apla"></span><button class="search-btn" aria-label="Show searchbox" id="mainSearchTrigger"><i class="search-btn_ico"></i></button>
        </div>
    </div>
    <div class="searchBar">
        <div class="container">
            <div class="row"><a href="/ru/" class="logo">

            </a>
                <div class="search" id="searchbox">
                    <form action="/ru/search/index" data-selected="/ru/" method="get" id="searchForm" data-id="XX5XQFLXZE" data-key="497dc3da220564aa11802210a8e31707" data-index="shops_ru" data-lang="ru" data-home-url="/ru/" data-categories-url="/ru/categories" data-blog-url="/ru/mozhno-deshevle/">
                        <i class="fa fa-serch"></i>
                        <div class="input-group">

                            <input type="text" id="mainSearchInput" class="search_field form-control search-input" placeholder="Введите название магазина" data-url="" data-metric=""><span id="recentSearchContainer" role="listbox" class="aa-dropdown-menu">

                                    <div class="aa-dataset-1"><span class="aa-suggestions"></span></div>
                                </span>
                            <div class="input-group-btn"><button class="search_btn" type="button" aria-label="Поиск"><i class="fa fa-search"></i></button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>
<main class="main-content has-newsletter">
    <section class="brandbar-banner has-bg-grey">

        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="swiper-container" id="swiper-brand">
                        <div class=" swiper-wrapper">
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#.png"></a></div>
                            <div class="swiper-slide"><a href="" title="" class="brand_ico" style="background:#ffffff;"><img title="" alt="" class="img-responsive" src="#"></a></div>
                            <div class="swiper-slide"><a href="" class="show_more">
                                <p>
                                    <span> Еще <i class="fa fa-angle-double-right" aria-hidden="true"></i></span></p>
                            </a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="card_list has-bg-grey" id="card-list-tab">
        <div class="container">
            <div id="homeTab" class="card-nav">
                <ul class="nav">
                    <li><span data-target="#tab_1" data-toggle="tab" aria-controls="tab_1" id="popularTab1">
                                Категория 1
                            </span></li>
                    <li><span data-target="#tab_2" data-toggle="tab" aria-controls="tab_1" id="popularTab2" >
                                Категория 2
                            </span></li>
                    <li><span data-target="#tab_3" data-toggle="tab" aria-controls="tab_1" id="popularTab3">
                                Категори 3
                            </span></li>
                </ul>
            </div>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="tab_1">
                    <div class="offer_box offer_row coupon-padding type-code" id="cb_mytoys_126710">
                        <div class="offer_item" data-picometric-redirects-on="0" data-ga="offer-cta" data-action="showoffer">
                            <div class="offer_body">
                                <figure class="offer_img" style="background-color: #ffffff">
                                    <div class="offer_align"><img src="" alt="" title="" class=""></div>
                                </figure>
                                <ul class="offer_label-list">
                                    <li class="is-orange">Подпись</li>
                                </ul>
                                <h3 class="offer_box-title"><a href="/ru/#cid=126710" title="">
                                    описание описание описание описание описание описание описание
                                </a></h3>
                            </div>
                            <div class="offer_swipe">
                                <div class="offer_swipe-content">
                                    <ul class="offer_list">

                                        <li>
                                            <div class="time time-offer-box time--box" data-current-time="2018-10-29 10:47:53" data-countdown="2018-10-31 23:59:00"><i class="fa fa-clock-o"></i></div>
                                        </li>
                                        <li>
                                            <i class="">
                                                пользователь
                                            </i>
                                        </li>
                                        <li><i class="fa fa-user"></i><span>312</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- Navigation buttons -->

            </div>
            </section><!-- end: polecane w tym tygodniu  -->
        </div>
    </div>

</main>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
