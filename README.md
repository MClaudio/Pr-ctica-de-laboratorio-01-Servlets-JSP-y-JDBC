# Practica-de-laboratorio-01-Servlets-JSP-y-JDBC
1.	Desarrollar una aplicación con tecnología JEE para gestionar una agenda telefónica en la web.
Para el desarrollo de la aplicación se toma en cuenta el diagrama de clases propuesto en la práctica:
![diagrama](https://user-images.githubusercontent.com/15615518/81624664-62444f00-93bc-11ea-90f2-c4d28c027781.png)
Para la conexión y persistencia a la base de datos se usa el patrón de diseño DAO comenzando con el desarrollo se crean las clases de usuario y teléfono.

![img1](https://user-images.githubusercontent.com/15615518/81624764-97e93800-93bc-11ea-85f2-1c5456be2315.png)

![img2](https://user-images.githubusercontent.com/15615518/81624792-b64f3380-93bc-11ea-84ab-3fce63711057.png)

Al crear las clases se crea la estructura DAO se crean todas las clases necesarias para la interacción con la base de datos.

![img3](https://user-images.githubusercontent.com/15615518/81624939-1c3bbb00-93bd-11ea-9f77-aac87b657f07.png)

También creamos la estructura de la base de datos, así como su módulo de conexión.

![img4](https://user-images.githubusercontent.com/15615518/81624993-44c3b500-93bd-11ea-8018-89247b8a4c06.png)

Para este paso es importante contar con la librería de conexión para MySQL de esta forma podremos acceder a la base de datos para crear el CRUD de usuarios y teléfonos también incluiremos las librerías de JSTL para la manipulación de archivos JSP todas estas librerías se colocan en la carpeta WEB-INF para que java los pueda reconocer.

![img5](https://user-images.githubusercontent.com/15615518/81625049-6fae0900-93bd-11ea-9514-1f7aa12bb069.png)
 
Para el registro de usuarios se proporciona un formulario de registro con los datos necesarios.

![img6](https://user-images.githubusercontent.com/15615518/81625134-9b30f380-93bd-11ea-8409-70aa9f2a92d7.png)

En el siguiente formulario el usuario tendrá que ingresar sus datos como nombre, apellido, cedula, correo y una contraseña para acceder al panel de usuarios el servlet que gestiona el registro de usuario se encargara de almacenar en la base de datos.
El servlet tomará los datos por POST y procederá a realizar la conexión a la base de datos mediante la arquitectura DAO para realizar la inserción de los datos.

![img7](https://user-images.githubusercontent.com/15615518/81625193-c0bdfd00-93bd-11ea-862c-20880001b254.png)

Una vez registrado el usuario podrá iniciar sesión con su correo y su contraseña el servlet de java administrara el registro y la validación de usuario si es que existe en la base de datos a continuación presento el servlet que gestiona el inicio de sesión.

![imagen](https://user-images.githubusercontent.com/15615518/81625223-dcc19e80-93bd-11ea-9a8c-a06560b6c130.png)

El método findUser se crea en el UserDao este método recibirá un correo y una contraseña para verificar en la base de datos si es que encuentra un usuario se creara las variables de sesión y redirige a su perfil.
En la siguiente imagen se presenta la página del usuario.

![imagen](https://user-images.githubusercontent.com/15615518/81625241-eea34180-93bd-11ea-91a5-cd03cc9bc9d5.png)

En este apartado el usuario podrá ver sus contactos, agregar, eliminar y editar cada número registrado por él. Lo métodos de el CRUD del teléfono se presenta a continuación.
Registro de teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625271-01b61180-93be-11ea-9262-69aea2c7b78e.png) 

![imagen](https://user-images.githubusercontent.com/15615518/81625426-8a34b200-93be-11ea-8524-e8bee55d7fd7.png)

Editar teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625452-9ae52800-93be-11ea-8833-3c24429c411d.png)

![imagen](https://user-images.githubusercontent.com/15615518/81625468-a8021700-93be-11ea-95ea-2e40a7a2f56f.png)

Eliminar teléfono.
Para eliminar el teléfono se hace uso del método GET del servlet que gestiona el editar teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625488-b6e8c980-93be-11ea-849a-68186b4916a6.png) 

![imagen](https://user-images.githubusercontent.com/15615518/81625505-c700a900-93be-11ea-897f-0c0b5b6c915f.png)

En la sección publica los usuarios podrán buscar a usuarios registrados en la plataforma para visualizar sus números.

![imagen](https://user-images.githubusercontent.com/15615518/81625531-d4b62e80-93be-11ea-93a7-8ddfa63b2780.png) 

El servlet que gestiona la búsqueda recibirá por GET el correo del usuario o la cedula para posteriormente hacer la consulta a la base de datos.

![imagen](https://user-images.githubusercontent.com/15615518/81625551-e4ce0e00-93be-11ea-8616-215836dacd08.png)

A continuación, presentaremos los métodos de conexión a la base de datos los métodos referentes al teléfono ya que de los usuarios es prácticamente igual.
Creación de la tabla.

![imagen](https://user-images.githubusercontent.com/15615518/81625661-26f74f80-93bf-11ea-8209-3d9339998bac.png)

Creación del teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625697-41312d80-93bf-11ea-801c-8997d481c84e.png)

Buscar un teléfono por el id.

![imagen](https://user-images.githubusercontent.com/15615518/81625717-4f7f4980-93bf-11ea-85e2-aca70c06b5b0.png)

Actualizar un teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625738-5efe9280-93bf-11ea-9d53-52b2dbdde7b1.png)

Eliminar un teléfono.

![imagen](https://user-images.githubusercontent.com/15615518/81625764-70e03580-93bf-11ea-91b1-c3a61866fdc9.png)

Buscar los teléfonos de un usuario.

![imagen](https://user-images.githubusercontent.com/15615518/81625781-7f2e5180-93bf-11ea-8303-6b7a4a451cd1.png) 

Listar los teléfonos buscados por un número.

![imagen](https://user-images.githubusercontent.com/15615518/81625798-8e150400-93bf-11ea-9888-0bf214dffb1a.png)

Todos estos métodos permiten listar, agregar, editar y eliminar un teléfono dependiendo del usuario propietario de dicho número.
Para finalizar visualizaremos la pagina índex donde se muestra información de la plataforma.

![imagen](https://user-images.githubusercontent.com/15615518/81625816-98370280-93bf-11ea-9bc4-1fcb504cad59.png)

![imagen](https://user-images.githubusercontent.com/15615518/81625840-a5ec8800-93bf-11ea-8444-611ad0c8b833.png)


### RESULTADO(S) OBTENIDO(S):

Implementar el modelo DAO para la persistencia en la base de datos y mantener separado la lógica de negocio con la interfaz y la arquitectura del sitio.

### CONCLUSIONES:

BookContact es el primer sitio creado con el modelo DAO para la persistencia de datos de la base de datos MySQL este modelo hace que sea sencillo el CRUD en la base de datos y mantener un orden en la programación teniendo por separado todos los módulos que conforman la lógica de negocio.

### RECOMENDACIONES:

Implementar el modelo DAO definir claramente lo que se quiere hacer claro que este modelo es bastante flexible ya que permite incrementar métodos que se necesiten, pero una buena planificación evita estos incrementos.
