FROM python:3.10.4-alpine3.16
WORKDIR application
EXPOSE 5000
COPY requirements.txt ./
RUN pip3 install -r requirements.txt

COPY . .

CMD [ "python", "./main.py" ]