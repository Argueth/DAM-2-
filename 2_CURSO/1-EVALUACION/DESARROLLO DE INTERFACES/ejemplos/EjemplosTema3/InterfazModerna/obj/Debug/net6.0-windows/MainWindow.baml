   M S B A M L   `   `   `  ����J  FInterfazModerna, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:InterfazModernaInterfazModerna  5   	        InterfazModerna.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   /localclr-namespace:InterfazModerna     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � WindowStyle$
 None=�5	   	    � 
ResizeMode$ NoResize=�5
   	    � WindowStartupLocation$ CenterScreen=�5   	   
������  � AllowsTransparency$
 True��5   	   .��5      ��  �� CornerRadius$ 50��6   ��5   
   �� 5       �� ImageSource$ img/fondo.jpg��6    j� Stretch$
 Fill=�5      ._�5   
   �� $ 40��6   $��5q�5       J� Opacity$	 0.7Q�5      ��5      �� 5      	 �� 
StartPoint$		 0,0&�6&   
 �� EndPoint$	
 1,1&�67   .��5      �  � Color$ 	#FFD82A2A��6#    � Offset$ 0Q�65   � 5      $ 	#FFD8C12A��6#   $
 0.15Q�65   � 5      $ 	#FF5FD82A��6#   $	 0.3Q�65   � 5      $ 	#FF2AD8D4��6#   $
 0.45Q�65   � 5      $ 	#FF2A35D8��6#   $	 0.6Q�65   � 5      $ 	#FFEE9EF7��6#   $
 0.75Q�65   � 5       $ 	#FFC1168B��6#   $ 1Q�65   5!      ��5$      �� 5%      $		 0,0&�6&   $	
 1,0&�67   .��5&      � $ 	#FFC1168B��6#   $ 0Q�65   � 5'      $ 	#FFAD5FFF��6#   $
 0.15Q�65   � 5(      $ 	#FF2A35D8��6#   $
 0.30Q�65   � 5)      $ 	#FF2AD8D4��6#   $
 0.45Q�65   � 5*      $ 	#FF5FD82A��6#   $
 0.60Q�65   � 5+      $ 	#FFD8C12A��6#   $
 0.75Q�65   � 5,      $ 	#FFD82A2A��6#   $ 1Q�65   5-      ._�50      �  � RowDefinitions 51      �� 52      $��30 �6$   �� 53      .+�56      � $��0��6    � ColumnDefinitions 57      �� 58      �� 59      $��25 �6+   �� 5:      $��25 �6+   �� 5;      $��5 �6+   .+�5>      �� -   5         ��Name$ btnMinimize��5>      $��0q�5?      $��-��5@      
�������$��16(�5B      $��
Montserrat)�5C       � Cursor$
 Hand��5D      $��1��5E      ��5G      �� 5H       �� 
TargetType" ��6$   .�5I   "   ��  �� Property � �� �� Value �#28AEED6?    �� Triggers 5J   "   P� 5K   &    P� Property �@J�IsMouseOver P� Value$
 True��6E   . �5L   *   ��  � �� �#278BEF6G   5M   '   5O      ��5Q      �� 5R       �� 
TargetType" ��6.   .R�5S   "   �� $��18��6)   $��18��64   $ 9��5T   )   #��z��5U   )   ._�5V   &   �� $��Center=�67   $��Center=�5W   7   5X   #   5Y      5[      �� 5]      -   5        $ btnClose��5]      $��0q�5^      $��X��5_      
�������$��12(�5a      $��
Montserrat)�5b      $
 Hand��5c      $��2��5d      ��5f      �� 5g      " ��6$   .�5h   "   ��  � ��
 �  ��6?    5i   "   P� 5j   &    �@J�IsMouseOver$
 True��6E   . �5k   *   ��  � �� �#C62DAE6G   5l   '   5n      ��5p      �� 5q      " ��6.   .R�5r   "   �� $��18��6)   $��18��64   $ 9��5s   )   #��z��5t   )   ._�5u   &   �� $��Center=�67   $��Center=�5v   7   5w   #   5x      5z      5{      5|      5~      5      5�      