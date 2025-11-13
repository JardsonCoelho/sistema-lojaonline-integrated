async function fetchProducts() {
  try {
    const res = await fetch('/api/produtos');
    const products = await res.json();
    renderProducts(products);
  } catch (e) {
    console.error('Erro ao buscar produtos', e);
    document.getElementById('products').innerHTML = '<div class="error">Não foi possível carregar produtos.</div>';
  }
}

function renderProducts(products) {
  const container = document.getElementById('products');
  container.innerHTML = '';
  if (!products || products.length === 0) {
    container.innerHTML = '<div class="empty">Nenhum produto cadastrado.</div>';
    return;
  }
  products.forEach(p => {
    const card = document.createElement('div');
    card.className = 'product-card';
    card.innerHTML = `
      <img src="/placeholder.png" alt="${p.nome}" class="product-image"/>
      <div class="product-body">
        <h3 class="product-title">${p.nome}</h3>
        <p class="product-desc">${p.descricao || ''}</p>
        <div class="product-bottom">
          <span class="price">R$ ${p.preco}</span>
          <button class="buy-btn" onclick="addToCart('${p.id}')">Adicionar</button>
        </div>
      </div>
    `;
    container.appendChild(card);
  });
}

function addToCart(id) {
  alert('Adicionar ao carrinho: ' + id + ' (funcionalidade de carrinho ainda não implementada)');
}

window.onload = fetchProducts;
