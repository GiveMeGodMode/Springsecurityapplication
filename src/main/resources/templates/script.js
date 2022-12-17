const clonBtn =() => {
    const elem = document.getElementById('firstEl');
    const cloneElement = elem.cloneNode(true);

    const elems = document.querySelector('.image');
    elems.after(cloneElement);
}


const addElemen = () => {

    const elementImage = document.querySelector('.one_wayticket');
    const newEl = document.createElement('img');

    newEl.setAttribute('src', 'img/1.gpg');
    newEl.classList.add('add_image');

    elementImage.append(newEl);

}