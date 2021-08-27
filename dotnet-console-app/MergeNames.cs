using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class MergeNames
{
    public static string[] UniqueNames(string[] names1, string[] names2)
    {
        return names1.Concat(names2).Distinct().ToArray();
    }

    public static void Run(string[] args)
    {
        string[] names1 = new string[] { "Ava", "Emma", "Olivia" };
        string[] names2 = new string[] { "Olivia", "Sophia", "Emma" };
        Console.WriteLine(string.Join(", ", MergeNames.UniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}