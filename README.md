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
   git clone https://github.com/tu-usuario/conversor-moneda-java.git
2. Crea el archivo src/config.properties con tu API Key de [ExchangeRate-API](https://www.exchangerate-api.com/):

   API_KEY=[tu_api_key]
   
4. Compila y ejecuta.
