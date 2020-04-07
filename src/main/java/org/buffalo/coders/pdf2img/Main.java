/*
 * #%L
 * org.buffalo-coders:pdf2img
 * %%
 * Copyright (C) 2019 Buffalo Coders
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.buffalo.coders.pdf2img;

import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Main {

    private static final int DPI = 300;

    private static final String IMG_FMT = "JPEG";

    private static final String IMG_EXT = "jpg";

    private static final ImageType IMG_TYPE = ImageType.RGB;

    public static void main(String[] args) throws Exception {
        final String pdf = args[0];
        final File dir = new File(pdf.replace(".pdf", ""));
        dir.mkdirs();

        try (final PDDocument document = PDDocument.load(new File(pdf))) {
            System.out.println("PDF: " + pdf);
            final PDFRenderer pdfRenderer = new PDFRenderer(document);

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                System.out.println("PAGE: " + (page + 1));
                ImageIO.write(pdfRenderer.renderImageWithDPI(page, DPI, IMG_TYPE), IMG_FMT,
                        new File(dir, String.format("%05d.%s", (page + 1), IMG_EXT)));
            }
        }
    }

}
