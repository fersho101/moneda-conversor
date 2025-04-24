# 💱 Conversor de Monedas en Java  

Aplicación de consola que convierte entre monedas usando [ExchangeRate-API](https://www.exchangerate-api.com/).  

## 🚀 Funcionalidades  
- ✅ Conversión de una moneda a otra (ej: USD → EUR).  
- 🔄 Conversión de una moneda a múltiples monedas (ej: USD → EUR, JPY, MXN).  
- 📊 Validación de entradas (solo acepta valores numéricos válidos).  
- 🔒 API Key protegida en archivo de configuración.  

## 📦 Requisitos  
- Java 8 o superior.  
- Librería `org.json` ([descargar .jar](https://repo1.maven.org/maven2/org/json/json/20231013/json-20231013.jar)).  

## 🛠 Cómo Ejecutarlo  
1. Clona el repositorio:    
   git clone https://github.com/fersho101/moneda-conversor.git
2. Crea el archivo src/config.properties con tu API Key de [ExchangeRate-API](https://www.exchangerate-api.com/):

   API_KEY=[tu_api_key]
   
3. Compila y ejecuta.

## 📌 Próximas Mejoras
Añadir historial de conversiones con SQLite.

Interfaz gráfica con JavaFX.

Soporte para criptomonedas.

## 🤝 Contribuir
¡Pull requests son bienvenidos! Reporta bugs o sugerencias en Issues.
