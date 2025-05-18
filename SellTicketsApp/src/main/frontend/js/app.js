document.addEventListener('DOMContentLoaded', function() {

    fetch('/api/tickets/films')
        .then(response => response.json())
        .then(data => displayFilms(data));

});

function displayFilms(films) {

    const filmsDiv = document.getElementById('films');

    films.forEach(film => {

        const filmDiv = document.createElement('div');
        filmDiv.className = 'film';

        const title = document.createElement('h2');
        title.innerText = film.title + ' - Доступно билетов: ' + film.availableTickets + ' - Продано: ' + film.soldTickets ;

        const buyButton = document.createElement('button');
        buyButton.innerText = 'Купить билет';

        buyButton.onclick = function() { buyTicket(film.id); };

        filmDiv.appendChild(title);
        filmDiv.appendChild(buyButton);

        filmsDiv.appendChild(filmDiv);

      });
}

function buyTicket(filmId) {

      const ticketNumber = prompt("Введите номер билета (1-3):");

      fetch(`/api/tickets/buy/${filmId}/${ticketNumber}`, { method: 'POST' })
          .then(response => response.text())
          .then(message => alert(message));
}