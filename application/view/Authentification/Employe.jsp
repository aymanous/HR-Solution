<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>HR Solution| </title>

  <!-- Bootstrap core CSS -->

  <link href="css/bootstrap.min.css" rel="stylesheet">

  <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
  <link href="css/animate.min.css" rel="stylesheet">

  <!-- Custom styling plus plugins -->
  <link href="css/custom.css" rel="stylesheet">
  <link href="css/icheck/flat/green.css" rel="stylesheet">
  
  <!-- switchery -->
  <link rel="stylesheet" href="css/switchery/switchery.min.css" />

  <script src="js/jquery.min.js"></script>

  <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>


<body class="nav-md">

  <div class="container body">


    <div class="main_container">

      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">

          <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-tasks"></i> <span>HR Solution</span></a>
          </div>
          <div class="clearfix"></div>


          <!-- menu prile quick info -->
          <div class="profile">
            <div class="profile_pic">
              <img src="images/img2.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2>Bradley Greer</h2>
            </div>
          </div>
          <!-- /menu prile quick info -->

          <br />

          <!-- sidebar menu -->
           <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
              <h3>C++ developer</h3>
              
              <br>

              <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                   <ul class="nav child_menu" style="display: none">
                    <li><a href="#">main</a>
                    </li>
                   
                    
                    
                   </ul>
                </li>
                <li><a><i class="fa fa-calendar"></i> Holiday <span class="fa fa-chevron-down"></span></a>
                  	
                    <ul class="nav child_menu" style="display: none">
                    
                    <c:set var="titleURL">
                    <c:url value="demandes_conges">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Requested</a>
                    </li>
                    
                    <c:set var="titleURL">
                    <c:url value="Employe_Conge">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Current</a></li>
                    
                       <c:set var="titleURL">
                    <c:url value="archive_conges">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Archive</a></li>
                     
                   </ul>
                </li>
               
                
                
                <li><a><i class="fa fa-dollar"></i> Wage review <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                  <c:set var="titleURL">
                    <c:url value="Employe_Fiche">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Basic Wage</a>
                    </li>
                    
                    <c:set var="titleURL">
                    <c:url value="archive_salaire_employe">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Archive</a>
                    </li>
                    
   
                  </ul>
                </li>
                
               
				
		
			
				
				
				<li><a><i class="fa fa-briefcase"></i> Mission <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                  
                  <c:set var="titleURL">
                    <c:url value="Employe_missions">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    
                    <li><a href="${titleURL}">Show all</a>
                    </li>
                    
                  </ul>
                </li>
                
                <li><a><i class="fa fa-institution"></i> Training <span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu" style="display: none">
                  
                  <c:set var="titleURL">
                    <c:url value="chef_d_formations">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Requested</a>
                    </li>
                     
                  <c:set var="titleURL">
                    <c:url value="liste_d_formations">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Current</a>
                    </li>
                  
                  <c:set var="titleURL">
                    <c:url value="demande_formation">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
             		</c:set>
                    <li><a href="${titleURL}">Archive</a>
                  </ul>
                </li>
				
                
              </ul>
            </div>
            

          </div>
          <!-- /sidebar menu -->

          <!-- /menu footer buttons -->
          
          <!-- /menu footer buttons -->
        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">

        <div class="nav_menu">
          <nav class="" role="navigation">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="images/img2.jpg" alt="">Bradley Greer
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                  
                  <li>
                    <a href="javascript:;">Help</a>
                  </li>
                  <li><a href="acceuil"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </li>
                </ul>
              </li>

              
            </ul>
          </nav>
        </div>

      </div>
      <!-- /top navigation -->

      <!-- page content -->
      <div class="right_col" role="main">
        <div class="">

          <div class="page-title">
            <div class="title_left">
              <h3>User Profile</h3>
            </div>
            <div class="title_right">
              
              </div>
            </div>
          </div>
          <div class="clearfix"></div>
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                
                <div class="x_content">

                  <div class="col-md-3 col-sm-3 col-xs-12 profile_left">

                    <div class="profile_img">

                      <!-- end of image cropping -->
                      <div id="crop-avatar">
                        <!-- Current avatar -->
                        <div class="avatar-view" title="Change the avatar">
                          <img src="images/img2.jpg" alt="Avatar">
                        </div>

                        <!-- Cropping modal -->
                        <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
                          <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                              <form class="avatar-form" action="crop.php" enctype="multipart/form-data" method="post">
                                <div class="modal-header">
                                  <button class="close" data-dismiss="modal" type="button">&times;</button>
                                  <h4 class="modal-title" id="avatar-modal-label">Change Avatar</h4>
                                </div>
                                <div class="modal-body">
                                  <div class="avatar-body">

                                    <!-- Upload image and data -->
                                    <div class="avatar-upload">
                                      <input class="avatar-src" name="avatar_src" type="hidden">
                                      <input class="avatar-data" name="avatar_data" type="hidden">
                                      <label for="avatarInput">Local upload</label>
                                      <input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
                                    </div>

                                    <!-- Crop and preview -->
                                    <div class="row">
                                      <div class="col-md-9">
                                        <div class="avatar-wrapper"></div>
                                      </div>
                                      <div class="col-md-3">
                                        <div class="avatar-preview preview-lg"></div>
                                        <div class="avatar-preview preview-md"></div>
                                        <div class="avatar-preview preview-sm"></div>
                                      </div>
                                    </div>

                                    <div class="row avatar-btns">
                                      <div class="col-md-9">
                                        <div class="btn-group">
                                          <button class="btn btn-primary" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees">Rotate Left</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="-15" type="button">-15deg</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="-30" type="button">-30deg</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button">-45deg</button>
                                        </div>
                                        <div class="btn-group">
                                          <button class="btn btn-primary" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees">Rotate Right</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="15" type="button">15deg</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="30" type="button">30deg</button>
                                          <button class="btn btn-primary" data-method="rotate" data-option="45" type="button">45deg</button>
                                        </div>
                                      </div>
                                      <div class="col-md-3">
                                        <button class="btn btn-primary btn-block avatar-save" type="submit">Done</button>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <!-- <div class="modal-footer">
                                                  <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                                </div> -->
                              </form>
                            </div>
                          </div>
                        </div>
                        <!-- /.modal -->

                        <!-- Loading state -->
                        <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                      </div>
                      <!-- end of image cropping -->

                    </div>
                    <h3>Bradley Greer</h3>

                    <ul class="list-unstyled user_data">
                      <li><i class="fa fa-map-marker user-profile-icon"></i> San Francisco, California, USA
                      </li>

                      <li>
                        <i class="fa fa-briefcase user-profile-icon"></i> C++ Developper
                      </li>

                     
                    </ul>
					
					
					<c:set var="titleURL">
                    <c:url value="Employe_Infos">  
                       <c:param name="matricule" value="${ sessionScope.matricule }"/>     
                    </c:url>
            		 </c:set>
                    <a class="btn btn-success" href="${titleURL}"><i class="fa fa-edit m-right-xs"></i>Edit Profile</a>
                    <br />

                    <!-- start skills -->
                  <!--   <h4>Skills</h4>
                    <ul class="list-unstyled user_data">
                      <li>
                        <p>Web Applications</p>
                        <div class="progress progress_sm">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50"></div>
                        </div>
                      </li>
                      <li>
                        <p>Website Design</p>
                        <div class="progress progress_sm">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="70"></div>
                        </div>
                      </li>
                      <li>
                        <p>Automation & Testing</p>
                        <div class="progress progress_sm">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="30"></div>
                        </div>
                      </li>
                      <li>
                        <p>UI / UX</p>
                        <div class="progress progress_sm">
                          <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50"></div>
                        </div>
                      </li>
                    </ul>-->
                    <!-- end of skills -->

                  </div>
                  <div class="col-md-9 col-sm-9 col-xs-12">

                    <div class="profile_title">
                      <div class="col-md-6">
                        <h2>User Activity Report</h2>
                      </div>
                      
                    </div>
                    <!-- start of user-activity-graph -->
                    <div id="graph_bar" style="width:100%; height:280px;"></div>
                    <!-- end of user-activity-graph -->

                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        
		

          <script type="text/javascript">
            $(document).ready(function() {
              $('#birthday').daterangepicker({
                singleDatePicker: true,
                calender_style: "picker_4"
              }, function(start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
              });
            });
          </script>


         
	</div>
  </div>

 </div> 

  <script src="js/bootstrap.min.js"></script>

  <!-- bootstrap progress js -->
  <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
  <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
  <!-- icheck -->
  <script src="js/icheck/icheck.min.js"></script>
  <!-- tags -->
  <script src="js/tags/jquery.tagsinput.min.js"></script>
 <!-- chart js -->
  <script src="js/chartjs/chart.min.js"></script>

  <!-- moris js -->
  <script src="js/moris/raphael-min.js"></script>
  <script src="js/moris/morris.min.js"></script>

  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>
  
  
   <!-- image cropping -->
  <script src="js/cropping/cropper.min.js"></script>
  <script src="js/cropping/main.js"></script>

  <!-- daterangepicker -->
  <script type="text/javascript" src="js/moment/moment.min.js"></script>
  <script type="text/javascript" src="js/datepicker/daterangepicker.js"></script>

  <script>
    $(function() {
      var day_data = [{
        "period": "Jan",
        "Hours worked": 80
      }, {
        "period": "Feb",
        "Hours worked": 125
      }, {
        "period": "Mar",
        "Hours worked": 176
      }, {
        "period": "Apr",
        "Hours worked": 224
      }, {
        "period": "May",
        "Hours worked": 265
      }, {
        "period": "Jun",
        "Hours worked": 314
      }, {
        "period": "Jul",
        "Hours worked": 347
      }, {
        "period": "Aug",
        "Hours worked": 287
      }, {
        "period": "Sep",
        "Hours worked": 240
      }, {
        "period": "Oct",
        "Hours worked": 211
      }];
      Morris.Bar({
        element: 'graph_bar',
        data: day_data,
        xkey: 'period',
        hideHover: 'auto',
        barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
        ykeys: ['Hours worked', ''],
        labels: ['Hours worked', ''],
        xLabelAngle: 60
      });
    });
  </script>
  
  
  <!-- pace -->
  <script src="js/pace/pace.min.js"></script>
  
  <script src="js/custom.js"></script>


 
  
  <!-- /editor -->
</body>

</html>
