from unittest import TestCase
from textdistance.algorithms import Levenshtein


class TestLevenshteinSimilarity(TestCase):
    def test_similarity_should_return_full_match(self):
        alg = Levenshtein()
        result = alg.normalized_similarity("aaa", "aaa")
        self.assertEqual(1, result)

    def test_similarity_should_return_non_match(self):
        alg = Levenshtein()
        result = alg.normalized_similarity("aaa", "bbb")
        self.assertEqual(0, result)

    def test_similarity_should_return_half_match(self):
        alg = Levenshtein()
        result = alg.normalized_similarity("aaaa", "abab")
        self.assertEqual(0.5, result)