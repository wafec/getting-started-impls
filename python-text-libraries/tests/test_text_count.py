from text_libraries.text_count import count_chars
from unittest import TestCase


class TestTextCount(TestCase):
    def test_count_chars_should_return_correct(self):
        string = "abc"

        result = count_chars(string)

        self.assertEqual(3, result)