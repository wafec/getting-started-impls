from textdistance.algorithms import Levenshtein
from unittest import TestCase


class TestLevenshteinDistance(TestCase):
    def test_distance_should_return_full_match(self):
        alg = Levenshtein()
        result = alg.distance("aaa", "aaa")
        self.assertEqual(0, result)

    def test_distance_should_return_one_behind(self):
        alg = Levenshtein()
        result = alg.distance("aaa", "aba")
        self.assertEqual(1, result)

    def test_distance_should_return_two_behind(self):
        alg = Levenshtein()
        result = alg.distance("aaa", "acc")
        self.assertEqual(2, result)