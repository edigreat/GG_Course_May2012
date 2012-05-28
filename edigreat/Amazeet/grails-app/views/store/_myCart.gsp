<div id="divshoppingCart">
<h2>Carrito</h2>
<p>


	<g:if test="${!session.shoppingCart.items}">
No haz agregado ningun producto a tu carrito
</g:if>
	<g:else>

Ya estas comprando en la tienda

	<ul>
	<g:each in="${session.shoppingCart.items}" var="item">
	<li>${item.quantity}  ${item.product.name}</li>
	</g:each>
	</ul>
	<br />

	<b>Total : ${session.totalCompra}</b>

</g:else>

</p>
</div>

