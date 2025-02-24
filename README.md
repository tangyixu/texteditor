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
commit 1261e440fc14d275d1fc490eaccdbb676d98a4b5 (HEAD -> main, origin/main, origin/HEAD)
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 20:00:49 2025 -0600

    Fix errors; Attempt GapBuffer

commit 2be78dddd50c70474bec731ac07e24e90f8fe207
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 19:59:07 2025 -0600

    Add Changelog
commit 08c7197081b7707aad44cf907a6900461850a015 (HEAD -> main, origin/main, origin/HEAD)
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 19:19:21 2025 -0600

    Add property test

commit ad359c05189da7e17f65270116550aa11c60301b
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 19:18:44 2025 -0600

    Add part2

commit 0091f0892701aa1f740ec9801c473fe0b06d85ea
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 18:53:30 2025 -0600

    Complete tests

commit 671b8f9722cf40b68799481ec3476930edc0c252
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 18:06:55 2025 -0600

    Complete

commit 836f715c5817ac2932491946e608990d80ff9048
Author: unknown <tangyixu@grinnell.edu>
Date:   Sun Feb 23 17:04:59 2025 -0600

    Update README.md

commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:40:05 2025 -0600

    Project files

commit 02dc92144ecc088bcefb4a9798df0934efe300c1
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Thu Feb 13 12:39:53 2025 -0600

    initial commit
