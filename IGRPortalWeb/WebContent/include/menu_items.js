	var NoOffFirstLineMenus=1;			// Number of first level items
	var LowBgColor='#fff9b2';			// Background color when mouse is not over
	var LowSubBgColor='#fff9b2';			// Background color when mouse is not over on subs
	var HighBgColor='#0066b2';			// Background color when mouse is over
	var HighSubBgColor='#0066b2';			// Background color when mouse is over on subs
	var FontLowColor='#000000';			// Font color when mouse is not over
	var FontSubLowColor='#000000';		// Font color subs when mouse is not over
	var FontHighColor='#ffffff';			// Font color when mouse is over
	var FontSubHighColor='#ffffff';		// Font color subs when mouse is over
	var BorderColor='#cdd4da';			// Border color
	var BorderSubColor='#0066b2';			// Border color for subs
	var BorderWidth=1;				// Border width
	var BorderBtwnElmnts=1;				// Border between elements 1 or 0
	var FontFamily="Arial, Helvetica, Sans-serif"	// Font family menu items
	var FontSize=8;					// Font size menu items
	var FontBold=0;					// Bold menu items 1 or 0
	var FontItalic=0;					// Italic menu items 1 or 0
	var MenuTextCentered='left';			// Item text position 'left', 'center' or 'right'
	var MenuCentered='left';			// Menu horizontal position 'left', 'center' or 'right'
	var MenuVerticalCentered='top';		// Menu vertical position 'top', 'middle','bottom' or static
	var ChildOverlap=.2;				// horizontal overlap child/ parent
	var ChildVerticalOverlap=.2;			// vertical overlap child/ parent
	var StartTop=50;					// Menu offset x coordinate
//	var StartLeft=0;					// Menu offset y coordinate
	var StartLeft=(screen.width-750)/2;		// Menu offset y coordinate
	var VerCorrect=0;					// Multiple frames y correction
	var HorCorrect=0;					// Multiple frames x correction
	var LeftPaddng=5;					// Left padding
	var TopPaddng=2;					// Top padding
	var FirstLineHorizontal=1;			// SET TO 1 FOR HORIZONTAL MENU, 0 FOR VERTICAL
	var MenuFramesVertical=1;			// Frames in cols or rows 1 or 0
	var DissapearDelay=500;				// delay before menu folds in
	var TakeOverBgColor=1;				// Menu frame takes over background color subitem frame
	var FirstLineFrame='navig';			// Frame where first level appears
	var SecLineFrame='space';			// Frame where sub levels appear
	var DocTargetFrame='space';			// Frame where target documents appear
	var TargetLoc='';					// span id for relative positioning
	var HideTop=0;					// Hide first level when loading new document 1 or 0
	var MenuWrap=1;					// enables/ disables menu wrap 1 or 0
	var RightToLeft=0;				// enables/ disables right to left unfold 1 or 0
	var UnfoldsOnClick=0;				// Level 1 unfolds onclick/ onmouseover
	var WebMasterCheck=0;				// menu tree checking on or off 1 or 0
	var ShowArrow=1;					// Uses arrow gifs when 1
	var KeepHilite=1;					// Keep selected path highligthed
	var Arrws=['images/triright.gif',5,10,
	'images/tridown.gif',10,5,
	'images/trileft.gif',5,10];	// Arrow source, width and height

function BeforeStart(){return}
function AfterBuild(){return}
function BeforeFirstOpen(){return}
function AfterCloseAll(){return}


// Menu tree
//	MenuX=new Array(Text to show, Link, background image (optional), number of sub elements, height, width);
//	For rollover images set "Text to show" to:  "rollover:Image1.jpg:Image2.jpg"

Menu1=new Array("Certificate Enquiry","certificateMain.jsp","",9,20,127);
	Menu1_1=new Array("Depositor's Details","","",0,20,127);	
	Menu1_2=new Array("HIN Details","","",0,20,127);	
	Menu1_3=new Array("Nominee / Jt. Holders","","",0,20,127);	
	Menu1_4=new Array("Collection Ledger","","",0,20,127);	
	Menu1_5=new Array("Loan Ledger","","",0,20,127);	
	Menu1_6=new Array("Maturity Payment","","",0,20,127);	
	Menu1_7=new Array("Due Details","","",0,20,127);	
	Menu1_8=new Array("Growth Chart","","",0,20,127);	
	Menu1_9=new Array("Log Details","","",0,20,127);	

Menu2=new Array("","","",2);
	Menu2_1=new Array("","","",2,20,127);	
		Menu2_1_1=new Array("","","",0,20,127);
		Menu2_1_2=new Array("","","",0);

	Menu2_2=new Array("","","",0);

Menu3=new Array("Knowledge Centre","http://www.utiisl.co.in/faq/faqindex1.html","",5);
	Menu3_1=new Array("F A Q","http://www.utiisl.co.in/faq/faqindex1.html","",0,20,135);
	Menu3_2=new Array("Schemes of UTI I & II","http://www.utiisl.co.in/schinfo/schemes_of_1_11.html","",0,20,135);
	Menu3_3=new Array("Schemes hived to UTI II","http://www.utiisl.co.in/schinfo/old_new_names.html","",0,20,135);
	Menu3_4=new Array("Scheme Information","http://www.utiisl.co.in/schinfo/index.html","",3,20,135);
		Menu3_4_1=new Array("Rates","http://www.utiisl.co.in/schinfo/rates.html","",0,20,150);
		Menu3_4_2=new Array("Repurchase Starting Dts","http://www.utiisl.co.in/schinfo/repurdt.html","",0);
		Menu3_4_3=new Array("Scheme Termination Dts","http://www.utiisl.co.in/schinfo/termndt.html","",0);
	Menu3_5=new Array("Aftersales Forms","http://www.utiisl.co.in/utiforms/index.html","",0,20,135);

Menu4=new Array("Contact Us","http://www.utiisl.co.in/brnw.html","",2);
	Menu4_1=new Array("UTIISL Locations","http://www.utiisl.co.in/brnw.html","",0,20,127);
	Menu4_2=new Array("UTI Financial Centers","http://www.utimf.com/NASApp/cs/ContentServer?pagename=UTI/Lct-Cst/ContactUs","",0);

Menu5=new Array("Associate","","",5);
	Menu5_1=new Array("UTI Mutual Fund","http://www.utimf.com/","",0,20,127);
	Menu5_2=new Array("UTI Bank","http://www.utibank.co.in/","",0,20,127);
	Menu5_3=new Array("UTI SEL","http://www.utisel.com/","",0,20,127);
	Menu5_4=new Array("UTI ICM","http://www.utiicm.com/","",0,20,127);
	Menu5_5=new Array("UTI IAS","http://www.utiias.com/","",0,20,127);
