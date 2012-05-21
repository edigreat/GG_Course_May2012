<h2>Carrito</h2>
<p>
<g:if test="${!session.shoppingCart.items}">
  No has agregado ningún producto a tu carrito
</g:if>
<g:else>
  <ul>
  <g:each in="${session.shoppingCart.items}" var="item">
    <li>${item.quantity} - ${item.product.name}</li>
  </g:each>
  </ul>
</g:else>
</p>