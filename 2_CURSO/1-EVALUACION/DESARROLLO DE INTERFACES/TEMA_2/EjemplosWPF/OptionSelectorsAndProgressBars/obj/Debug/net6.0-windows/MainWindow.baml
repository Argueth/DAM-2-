   M S B A M L   `   `   `  ����Y  UOptionSelectorsAndProgressBars, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullO,clr-namespace:OptionSelectorsAndProgressBarsOptionSelectorsAndProgressBars  5   	   /    )OptionSelectorsAndProgressBars.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   >local,clr-namespace:OptionSelectorsAndProgressBars     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �  � RowDefinitions 5
   
   �� 5      $	��20* �6   �� 5      $	��30* �6   �� 5      $	��20* �6   �� 5      $	��20* �6    � ColumnDefinitions 5   
   �� 5      $	��20* �6   �� 5      $	��20* �6   .+�5   
   �� $��0��6   $��10q�6"   .+�5      �� $'��!Primer conjunto de radio buttons:��6   $��0 4 0 0q�5      �� 5       �� Orientation$ 
Horizontal=�6   .+�5      	�  	� 	GroupName$ 	rdoGroup1��6   $��Radio 1��5       d� 	IsChecked$
 TrueY�5      $��4q�5      	� 5      $ 	rdoGroup1��6   $��Radio 2��5       $��4q�5!      	� 5"      $ 	rdoGroup1��6   $��Radio 3��5#      $��4q�5$      5%      5&      �� 5(   
   $��1��6   $��10q�6"   .+�5)      �� $7��1Segundo conjunto de radio buttons no excluyentes:��6   $��0 4 0 0q�5*      �� 5,      $ 
Horizontal=�6   .+�5-      	� $��Radio 1��5.      $
 TrueY�5/      $��4q�50      51      �� 52      $ 
Horizontal=�6   .+�53      	� $��Radio 2��54      $��4q�55      56      �� 57      $ 
Horizontal=�6   .+�58      	� $��Radio 3��59      $��4q�5:      5;      5<      �� 5>   
   $��2��6   $��10q�6"   .+�5?      �� $'��!Tercer conjunto de radio buttons:��6   $��0 4 0 0q�5@      �� 5B      $ 
Horizontal=�6   .+�5C      	� $��Radio 1��5D      $
 TrueY�5E      $��4q�5F      	� 5G      $��Radio 2��5H      $��4q�5I      	� 5J      $��Radio 3��5K      $��4q�5L      5M      5N      �� 5P   
   $��3��6   $��10q�6"   .+�5Q      �� $��Set of checkboxes:��6   $��0 4 0 0q�5R      �� 5T      $ 
Horizontal=�6   .+�5U      �� $��
Checkbox 1��6   $
 TrueY�5V      $��4q�5W      �� 5X      $��
Checkbox 2��6   $
 TrueY�5Y      $��4q�5Z      �� 5[      $��
Checkbox 3��6   $��4q�5\      5]      5^      �� 5`   
   $��1��6   $��0��6%   $��10q�62   .+�5a      �� $$��Progress Indicator set at: 20%��6   � 5b      $��30��6   $	��0 4q�5c       � Minimum$ 0Q�5d       � Maximum$	 100Q�5e       � Value$ 20Q�5f      5g      �� 5i   
   $��1��6   $��1��6%   $��10q�62   .+�5j      �� $$��Progress Indicator set at: 70%��6   � 5k      $��30��6   $	��0 4q�5l      $ 0Q�5m      $	 100Q�5n      $ 70Q�5o      5p      �� 5r   
   $��1��6   $��2��6%   $��10q�62   .+�5s      �� $.��(Progress Indicator set at: Indeterminate��6   � 5t      $��30��6   $	��0 4q�5u      $ 0Q�5v      $	 100Q�5w      	 � IsIndeterminate$
	 True��5x      5y      5z      5{      