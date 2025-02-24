# CSC 207: Text Editor

**Author**: Tiffany Tang

## Resources Used

JDK-23 is used; NetBeans is used as the IDE for this project.

This is instructed by:
https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html

## Part 2: Analysis
1) The size of the String backingData.
2) Two substring methods called to create part1 and part2;
creating a new string copying the result of appending part1 and part2;
3) T(n) = n + n + n
4) insert is O(n).
5) My insert method contains three parts: first, copying one part of the original
string and name it part1. Since strings are immutable, and I am creating a new string,
the time of copying the string would be related to the size of the original string
which is n. Also, since I did the same thing to another string and name it part2,
it causes the same time as that of part1. Finally, assigning the appended string
of part1 and part2 back to the original string also has a runtime related to the size.
That's because strings are not immutable, and I am copying the contents of the appended string,
make a new one, and assign it back. Therefore, every operations that I have used
all have a runtime relevant to the input of the operation, which could lose much 
efficiency when the String has a big size.

## Changelog
