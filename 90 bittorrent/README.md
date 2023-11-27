# DESARROLLO DE UN CLIENTE BITTORRENT

```mermaid
stateDiagram-v2
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Cliente: Cliente\nPeer 3 \n(leech)
        Tracker: Tracker

        Note right of Tracker
                Deberá llevar un registro de los peers que 
                se conectan a él y de los archivos que
                están compartiendo. Así como las partes
                que tiene cada uno de ellos.
        end note
```

## Anunciarse al tracker

El cliente se conectará al tracker para anunciar los archivos que tiene asociados al tracker. El tracker llevará un registro de los peers que se conectan a él y de los archivos que están compartiendo. Así como las partes que tiene cada uno de ellos.


```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Tracker: Tracker

        Cliente --> Tracker: Anunciar peer
```

## Descargar partes

El cliente solicitará la lista de peers, del archivo que quiere descargar, al tracker.

```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Tracker: Tracker

        Cliente --> Tracker: Solicitar lista de peers
```

A partir de la lista de peers, el cliente se conectará a cada uno de ellos para descargar las partes que le faltan. Para ello, se establecerá una conexión TCP con cada uno de ellos.

```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Tracker: Tracker

        Cliente --> Peer1: 3. Handshake
        Cliente --> Peer2: 3. Handshake
```

```mermaid
stateDiagram-v2
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Cliente: Cliente\nPeer 3 \n(leech)
        Tracker: Tracker

        Cliente --> Peer1: 4. Descargar partes
        Cliente --> Peer2: 4. Descargar partes
```

## Actualización del tracker

El tracker cada cierto tiempo pedirá a los peers que le envíen la lista de partes que tienen. El tracker actualizará la información de los peers y de los archivos que están compartiendo.

```mermaid
stateDiagram-v2
        Tracker: Tracker
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Cliente: Cliente\nPeer 3 \n(leech)

        Tracker --> Peer1: Actualizar partes
        Tracker --> Peer2: Actualizar partes
        Tracker --> Cliente: Actualizar partes

        Peer1 --> Tracker: Enviar lista de partes
        Peer2 --> Tracker: Enviar lista de partes
        Cliente --> Tracker: Enviar lista de partes
```

## Actualización de peers

El cliente cada cierto tiempo pedirá al tracker la lista de peers que tienen el archivo que quiere descargar. El cliente actualizará la lista de peers. En caso de que haya nuevos peers, el cliente se conectará a ellos para descargar las partes que le faltan.

```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Peer4: Peer 4 \n(leech)
        Tracker: Tracker

        Cliente --> Tracker: Actualizar peers
        Tracker --> Cliente: Enviar lista de peers
        
```

```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Peer4: Peer 4 \n(leech)
        Tracker: Tracker

        Cliente --> Peer4: Handshake
```

```mermaid
stateDiagram-v2
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Peer4: Peer 4 \n(leech)
        Tracker: Tracker

        Cliente --> Peer4: Descargar partes
```

## Manejo de desconexiones

En caso de que un peer se desconecte, los peers que estén conectados a él deberán guardar las partes que han descargado hasta el momento. Así como el número de bytes que han descargado. En caso de que el peer se vuelva a conectar, los peers que estén conectados a él deberán enviarle las partes que han descargado hasta el momento. Así como el número de bytes que han descargado.

```mermaid
stateDiagram-v2
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer4: Peer 4 \n(leech)
        Tracker: Tracker

        Peer4 --> Cliente: Desconectar
        Cliente --> Cliente: Guardar bytes descargados
```

```mermaid
stateDiagram-v2
        Peer1: Peer 1 \n(leech)
        Peer2: Peer 2 \n(seed)
        Cliente: Cliente\nPeer 3 \n(leech)
        Peer4: Peer 4 \n(leech)
        Tracker: Tracker

        Peer4 --> Cliente: Conectar
        Cliente --> Peer4: Enviar bytes descargados
```

En caso de que el peer que se desconectó no se vuelva a conectar antes de que el cliente termine de descargar las partes que le faltaban, el cliente deberá conectarse a otro peer para reanudar la descarga de la parte desde el byte en que se quedó.
