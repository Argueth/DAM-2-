   M S B A M L   `   `   `  ����F  BCalculadora, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:CalculadoraCalculadora  5   	       Calculadora.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   +localclr-namespace:Calculadora     5   	     � Title$  Calculadora��5   	   $	��450��5	   	   $	��450��5
   	    � 	Resources 5       �� 
TargetType �� Property �� Value��%�  '��       '�� �     �� 5   
   " ��6   .�5      ��  � ��
 ����6+   �� 5       � ��
 �����6+   �� 5       � ��$ 45(�6)   �� 5       � ��$ DemiBold"�6+   5      �� 5   
   " ��6   .�5      ��  � ��
 ��  �6,   �� 5       � ��$ 2q�61   �� 5       �@��CornerRadius$ 4��6-   �� 5       � ��$ 5q�6'   5      5      .��5      � $��20, 15q�6    � RowDefinitions 5   
   �� 5      $��1* �6   �� 5      $��1* �6   �� 5      $��1* �6   �� 5      $��1* �6   �� 5      $��1* �6    � ColumnDefinitions 5!   
   �� 5"      $��1* �6   �� 5#      $��1* �6   �� 5$      $��1* �6   �� 5%      $��1* �6   �� 5&      $��1* �6   .+�5(   
   �� -   5         ��Name$ resultadoText��5)      $��0��5*      $��0��5+      $��5��5,      
���   �
�������$��0��5/       �� TextAlignment$ Right=�50      $��Center=�51      $��60(�52      $��5q�53      	 �� Padding$	 3q�54      �� 55   
   $��1��6   $��0��6   ._�56      �� -   5        $��7��56      6!   57      �� 58   
   $��1��6   $��1��6   ._�59      �� -   5        $��8��59      6!   5:      �� 5;   
   $��1��6   $��2��6   ._�5<      �� -   5        $��9��5<      6!   5=      �� 5>   
   $��1��6   $��3��6   ._�5?      �� -   5        $��/��5?      6!   5@      �� 5A   
   $��1��6   $��4��6   ._�5B      �� -   5        $��C��5B      6!   5C      �� 5D   
   $��2��6   $��0��6   ._�5E      �� -   5        $��4��5E      6!   5F      �� 5G   
   $��2��6   $��1��6   ._�5H      �� -   5        $��5��5H      6!   5I      �� 5J   
   $��2��6   $��2��6   ._�5K      �� -	   5        $��6��5K      6!   5L      �� 5M   
   $��2��6   $��3��6   ._�5N      �� -
   5        $��*��5N      6!   5O      �� 5P   
   $��2��6   $��4��6   ._�5Q      �� -   5        $	��√��5Q      6(   5R      �� 5S   
   $��3��6   $��0��6   ._�5T      �� -   5        $��1��5T      6!   5U      �� 5V   
   $��3��6   $��1��6   ._�5W      �� -   5        $��2��5W      6!   5X      �� 5Y   
   $��3��6   $��2��6   ._�5Z      �� -   5        $��3��5Z      6!   5[      �� 5\   
   $��3��6   $��3��6   ._�5]      �� -   5        $��-��5]      6!   5^      �� 5_   
   $��3��6   $��4��6   $��2��6.   ._�5`      �� -   5        $��+��5`      6!   5a      �� 5b   
   $��4��6   $��0��6   ._�5c      �� -   5        $��0��5c      6!   5d      �� 5e   
   $��4��6   $��1��6   ._�5f      �� -   5        $	��+/-��5f      $��35(�66   5g      �� 5h   
   $��4��6   $��2��6   ._�5i      �� -   5        $��.��5i      6!   5j      �� 5k   
   $��4��6   $��3��6   ._�5l      �� -   5        $��=��5l      6!   5m      5n      5o      