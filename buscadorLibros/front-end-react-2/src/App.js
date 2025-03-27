import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [book, setBook] = useState(''); 
  const [bookData, setBookData] = useState(null); 
  const [error, setError] = useState(''); 

  const handleInputChange = (event) => {
    setBook(event.target.value); 
  };

  const handleSubmit = (event) => {
    event.preventDefault(); 
    axios
      .get(`http://localhost:8080/api/book/${book}`) 
      .then((response) => {
        setBookData(response.data); 
        setError(''); 
      })
      .catch((error) => {
        setBookData(null);
        if (error.response) {
          setError(error.response.data.error || 'Book not found');
        } else {
          setError('An error occurred while fetching the book data.');
        }
      });
  };

  return (
    <div>
      <h1>Book Search</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={book}
          onChange={handleInputChange}
          placeholder="Enter a book name..."
        />
        <button type="submit">Search</button>
      </form>

      {/* Display the book data or error message */}
      {bookData && (
        <div>
          <h2>Book Details</h2>
          <p><strong>Name:</strong> {bookData.name}</p>
          <p><strong>Author:</strong> {bookData.author}</p>
          <p><strong>Quantity:</strong> {bookData.quantity}</p>
        </div>
      )}

      {error && <p style={{ color: 'red' }}>{error}</p>}
    </div>
  );
}

export default App;