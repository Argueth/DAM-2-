   M S B A M L   `   `   `  ����J  FInterfazModerna, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:InterfazModernaInterfazModerna  5   	        InterfazModerna.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   /localclr-namespace:InterfazModerna     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)    � WindowStyle$
 None=�5	   	    � 
ResizeMode$ NoResize=�5
   	    � WindowStartupLocation$ CenterScreen=�5   	   
������  � AllowsTransparency$
 True��5   	   .��5      ��  �� CornerRadius$ 50��6   ��5   
   �� 5       �� ImageSource$ img/fondo.jpg��6    j� Stretch$
 Fill=�5      ._�5   
   �� $ 40��6   $��5q�5       J� Opacity$	 0.4Q�5      ��5      �� 5      	 �� 
StartPoint$		 0,0&�6&   
 �� EndPoint$	
 1,1&�67   .��5      �  � Color$ #462AD8��6#    � Offset$ 0Q�63   � 5      $ #9EBAF7��6#   $
 0.75Q�63   � 5      $ #8A16C1��6#   $ 1Q�63   5      ��5       �� 5!      $		 0,1&�6&   $	
 1,0&�67   .��5"      � $ #462AD8��6#   $ 0Q�63   � 5#      $ #9EBAF7��6#   $
 0.75Q�63   5$      ._�5'      �  � RowDefinitions 5(      �� 5)      $��30 �6$   �� 5*      .+�5-      � $��0��6    � ColumnDefinitions 5.      �� 5/      �� 50      $��25 �6+   �� 51      $��25 �6+   �� 52      $��5 �6+   .+�55      �� -   5         ��Name$ btnMinimize��55      $��0q�56      $��-��57      
�������$��16(�59      $��
Montserrat)�5:       � Cursor$
 Hand��5;      $��1��5<      ��5>      �� 5?       �� 
TargetType" ��6$   .�5@   "   ��  �� Property � �� �� Value �#28AEED6?    �� Triggers 5A   "   P� 5B   &    P� Property �@J�IsMouseOver P� Value$
 True��6E   . �5C   *   ��  � �� �#278BEF6G   5D   '   5F      ��5H      �� 5I       �� 
TargetType" ��6.   .R�5J   "   �� $��18��6)   $��18��64   $ 9��5K   )   #��z��5L   )   ._�5M   &   �� $��Center=�67   $��Center=�5N   7   5O   #   5P      5R      �� 5T      -   5        $ btnClose��5T      $��0q�5U      $��X��5V      
�������$��12(�5X      $��
Montserrat)�5Y      $
 Hand��5Z      $��2��5[      ��5]      �� 5^      " ��6$   .�5_   "   ��  � �� �#DA34AE6?    5`   "   P� 5a   &    �@J�IsMouseOver$
 True��6E   . �5b   *   ��  � �� �#C62DAE6G   5c   '   5e      ��5g      �� 5h      " ��6.   .R�5i   "   �� $��18��6)   $��18��64   $ 9��5j   )   #��z��5k   )   ._�5l   &   �� $��Center=�67   $��Center=�5m   7   5n   #   5o      5q      5r      5s      5u      5v      5x      