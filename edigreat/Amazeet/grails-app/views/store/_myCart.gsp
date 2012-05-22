<h2>Carrito</h2>
<p>

	<g:if test="${!session.shoppingCart.items}">
No haz agregado ningun producto a tu carrito
</g:if>
	<g:else>

Ya estas comprando en la tienda  <b> ${session.shoppingCart.items.size()} </b> 

	<ul>
	<g:each in="${session.shoppingCart.items}" var="item">
	<li>${item.quantity}  ${item.product.name}</li>
	</g:each>
	</ul>
</g:else>
</p>
