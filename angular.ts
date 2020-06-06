for (let sliceIndex = 0; sliceIndex < slicesCount; ++sliceIndex) {
      const begin = sliceIndex * sliceSize;
      const end = Math.min(begin + sliceSize, bytesLength);

      const bytes = new Array(end - begin);
      for (let offset = begin, i = 0; offset < end; ++i, ++offset) {
        bytes[i] = byteCharacters[offset].charCodeAt(0);
      }
      byteArrays[sliceIndex] = new Uint8Array(bytes);
    }
    return new Blob(byteArrays);
