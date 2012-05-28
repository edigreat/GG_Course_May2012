<br />
<table border=1>
		<thead>
			<tr>
				<td>
				<b>	${message(code:'product.name.label',default:'Name')}</b>
				</td>
				<td>
				<b>	${message(code:'product.price.label',default:'Price')} </b>
				</td>
				<td>
		      <b>	${message(code:'shoppingCart.quantity.label',default:'Quantity')} </b>
				</td>
				<td>
			   <b>	${message(code:'shoppingCart.import.label',default:'Import')} </b>
				</td>

			</tr>
			</thead>

			<tbody>
			   <g:each in="${session.shoppingCart.items}" var="item">
			   <tr>
			   <td>${item.product.name}</td>
			   <td>$ ${item.product.price}</td>
            <td>${item.quantity} </td>
		      <td>${item.quantity * item.product.price }</td>
			   </tr>
            </g:each>
            <tr>
               <td>
				   &nbsp;
               </td>
				   <td>
				   &nbsp;   
               </td>
				   <td>
				   <b>Total: </b>
				   </td>
				   <td>
				   ${session.totalCompra}	
			      </td>
            </tr>
         </tbody>
</table>         
<br />

<button onclick="closeModal()">Volver</button> <br />

	<g:form action="cancelShoppingCart">
				<g:submitButton name="submit" value="Cancelar"/>
	</g:form>



