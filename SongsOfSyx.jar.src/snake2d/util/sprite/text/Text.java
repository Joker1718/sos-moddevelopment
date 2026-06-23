/*     */ package snake2d.util.sprite.text;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ public class Text
/*     */   extends Str implements SPRITE {
/*  13 */   protected int maxWidth = 2000;
/*     */   private int width;
/*     */   private int height;
/*     */   private Font font;
/*  17 */   private double scale = 1.0D;
/*     */   private boolean multipleLines = true;
/*     */   private boolean darken = false;
/*     */   
/*     */   public Text(Font font, CharSequence text) {
/*  22 */     super(text.length());
/*  23 */     this.font = font;
/*  24 */     set(text);
/*     */   }
/*     */   
/*     */   public Text(Font font, int size) {
/*  28 */     super(size);
/*  29 */     this.font = font;
/*  30 */     adjustWidth();
/*     */   }
/*     */   
/*     */   public Text(Font font, int size, int width) {
/*  34 */     super(size);
/*  35 */     this.font = font;
/*  36 */     adjustWidth();
/*     */   }
/*     */ 
/*     */   
/*     */   public Text clear() {
/*  41 */     super.clear();
/*  42 */     adjustWidth();
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(CharSequence string) {
/*  48 */     super.add(string);
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public Text darkBG() {
/*  53 */     this.darken = true;
/*  54 */     return this;
/*     */   }
/*     */   
/*     */   public Text adjustWidth() {
/*  58 */     COORDINATE c = this.font.getDim(this, 2147483647, this.scale);
/*  59 */     this.width = c.x();
/*  60 */     this.height = c.y();
/*  61 */     if (this.height == 0) {
/*  62 */       this.height = this.font.height(this.scale);
/*     */     }
/*  64 */     if (!this.multipleLines) {
/*  65 */       this.height = this.font.height(this.scale);
/*  66 */       if (this.width > this.maxWidth) {
/*  67 */         this.width = this.maxWidth;
/*     */       }
/*  69 */     } else if (this.width > this.maxWidth) {
/*  70 */       this.width = this.maxWidth;
/*  71 */       this.height = this.font.getHeight(this, this.width);
/*  72 */       this.width = this.font.getDim(this, this.width + 2, this.scale).x();
/*     */     } 
/*     */     
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public int maxWidth() {
/*  79 */     return this.maxWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text addBinary(int i) {
/*  84 */     super.addBinary(i);
/*  85 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text addBinary(long i) {
/*  90 */     super.addBinary(i);
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(long i, boolean format) {
/*  96 */     super.add(i, format);
/*  97 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(long i) {
/* 102 */     super.add(i);
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(double d) {
/* 108 */     super.add(d);
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(char chars) {
/* 114 */     super.add(chars);
/* 115 */     return this;
/*     */   }
/*     */   
/*     */   public Text para(CharSequence str) {
/* 119 */     if (length() > 0)
/* 120 */       s(); 
/* 121 */     add('(');
/* 122 */     add(str);
/* 123 */     add(')');
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Text s() {
/* 130 */     super.s();
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text s(int i) {
/* 136 */     super.s(i);
/* 137 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text add(boolean b) {
/* 142 */     super.add(b);
/* 143 */     return this;
/*     */   }
/*     */   
/*     */   public Text setFont(Font font) {
/* 147 */     this.font = font;
/* 148 */     this.height = font.height();
/* 149 */     adjustWidth();
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   public Font getFont() {
/* 154 */     return this.font;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Text set(CharSequence s) {
/* 162 */     clear();
/* 163 */     add(s);
/* 164 */     return adjustWidth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 173 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 178 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getHeight(int width) {
/* 182 */     return this.font.getHeight(this, width);
/*     */   }
/*     */   
/*     */   public Text setScale(double scale) {
/* 186 */     this.scale = scale;
/* 187 */     adjustWidth();
/* 188 */     return this;
/*     */   }
/*     */   
/*     */   public Text setMaxWidth(int max) {
/* 192 */     this.maxWidth = max;
/* 193 */     if (this.width > this.maxWidth)
/* 194 */       adjustWidth(); 
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 200 */     int width = X2 - X1;
/* 201 */     if (width <= 0) {
/* 202 */       width = this.maxWidth;
/*     */     }
/* 204 */     if (this.darken) {
/*     */ 
/*     */ 
/*     */       
/* 208 */       OPACITY old = CORE.renderer().opacity();
/* 209 */       OPACITY.O50.bind();
/* 210 */       COLOR.BLACK.render(r, X1 - 2, X1 + this.width + 2, Y1 - 2, Y1 + this.height + 2);
/* 211 */       old.bind();
/*     */     } 
/*     */     
/* 214 */     if (this.multipleLines) {
/* 215 */       this.font.render(r, this, X1, Y1, width, this.scale);
/*     */     } else {
/* 217 */       this.font.renderCropped(r, this, X1, Y1, width, this.scale);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Text setMultipleLines(boolean m) {
/* 222 */     this.multipleLines = m;
/* 223 */     adjustWidth();
/* 224 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 230 */     int width = X2 - X1;
/* 231 */     if (width <= 0) {
/* 232 */       width = this.maxWidth;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object other) {
/* 238 */     if (other instanceof CharSequence) {
/* 239 */       CharSequence o = (CharSequence)other;
/* 240 */       return o.toString().equalsIgnoreCase(toString());
/*     */     } 
/* 242 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text toCamel() {
/* 247 */     super.toCamel();
/* 248 */     adjustWidth();
/* 249 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text toLower() {
/* 254 */     super.toLower();
/* 255 */     adjustWidth();
/* 256 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Text toUpper() {
/* 261 */     super.toUpper();
/* 262 */     adjustWidth();
/* 263 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\text\Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */