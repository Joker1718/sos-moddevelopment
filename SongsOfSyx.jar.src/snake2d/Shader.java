/*     */ package snake2d;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Shader
/*     */ {
/*     */   protected int programID;
/*     */   private int vertexShaderID;
/*     */   private int fragmentShaderID;
/*  41 */   private int geometryShaderID = -1;
/*     */ 
/*     */   
/*     */   public Shader(double width, double height, String vertex, String geometry, String fragment) {
/*  45 */     this.programID = GL20.glCreateProgram();
/*  46 */     vertex = getFile(vertex, "v");
/*  47 */     vertex = vertex.replace("SCREEN_X", 2.0D / width);
/*  48 */     vertex = vertex.replace("SCREEN_Y", -2.0D / height);
/*     */     
/*  50 */     this.vertexShaderID = attachShader(vertex, this.programID, 35633);
/*     */     
/*  52 */     fragment = getFile(fragment, "f");
/*     */     
/*  54 */     this.fragmentShaderID = attachShader(fragment, this.programID, 35632);
/*     */ 
/*     */     
/*  57 */     if (geometry != null) {
/*  58 */       geometry = getFile(geometry, "g");
/*  59 */       this.geometryShaderID = attachShader(geometry, this.programID, 36313);
/*     */     } 
/*     */     
/*  62 */     link();
/*  63 */     bind();
/*  64 */     Printer.ln(" " + getClass() + ": " + this.programID + ", ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFile(String name, String append) {
/*  70 */     name = String.valueOf(name) + "_" + append + ".txt";
/*     */     try {
/*  72 */       InputStream fis = Shader.class.getResourceAsStream(name);
/*  73 */       byte[] bs = Alloc.bb(100000);
/*  74 */       int size = 0;
/*     */       while (true) {
/*  76 */         int r = fis.read();
/*  77 */         if (r == -1)
/*     */           break; 
/*  79 */         bs[size] = (byte)r;
/*  80 */         size++;
/*     */       } 
/*  82 */       byte[] res = Alloc.bb(size);
/*  83 */       for (int i = 0; i < res.length; i++) {
/*  84 */         res[i] = bs[i];
/*     */       }
/*  86 */       return new String(res, Charset.forName("utf-8"));
/*  87 */     } catch (Exception e) {
/*  88 */       throw new RuntimeException(name);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int attachShader(String source, int programID, int type) {
/*  95 */     int id = GL20.glCreateShader(type);
/*  96 */     if (id == 0) {
/*  97 */       throw new RuntimeException("shader didn't compile");
/*     */     }
/*  99 */     GL20.glShaderSource(id, source);
/* 100 */     GL20.glCompileShader(id);
/*     */     
/* 102 */     if (GL20.glGetShaderi(id, 35713) == 0) {
/* 103 */       throw new RuntimeException("Error creating shader\n" + 
/* 104 */           GL20.glGetShaderInfoLog(id, GL20.glGetShaderi(id, 35716)));
/*     */     }
/* 106 */     GL20.glAttachShader(programID, id);
/* 107 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void link() {
/* 116 */     GL20.glLinkProgram(this.programID);
/*     */     
/* 118 */     if (GL20.glGetProgrami(this.programID, 35714) == 0) {
/* 119 */       throw new RuntimeException("Unable to link shader program:");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind() {
/* 126 */     GL20.glUseProgram(this.programID);
/*     */   }
/*     */   
/*     */   protected void bindAttribute(int possition, String name) {
/* 130 */     GL20.glBindAttribLocation(this.programID, possition, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unbind() {
/* 137 */     GL20.glUseProgram(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dis() {
/* 143 */     unbind();
/*     */     
/* 145 */     GL20.glDetachShader(this.programID, this.vertexShaderID);
/* 146 */     GL20.glDetachShader(this.programID, this.fragmentShaderID);
/* 147 */     if (this.geometryShaderID != -1) {
/* 148 */       GL20.glDetachShader(this.programID, this.geometryShaderID);
/*     */     }
/*     */     
/* 151 */     GL20.glDeleteShader(this.vertexShaderID);
/* 152 */     GL20.glDeleteShader(this.fragmentShaderID);
/* 153 */     if (this.geometryShaderID != -1) {
/* 154 */       GL20.glDeleteShader(this.geometryShaderID);
/*     */     }
/*     */     
/* 157 */     GL20.glDeleteProgram(this.programID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getID() {
/* 164 */     return this.programID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getUniformLocation(String name) throws RuntimeException {
/* 169 */     int id = GL20.glGetUniformLocation(this.programID, name);
/* 170 */     if (id == -1 || GL20.glGetProgrami(this.programID, 35718) == 0)
/* 171 */       throw new RuntimeException("not able to find shader uniform: " + name); 
/* 172 */     return id;
/*     */   }
/*     */   
/*     */   public String getScreenVec(float width, float height) {
/* 176 */     float w = 2.0F / width;
/* 177 */     float h = -2.0F / height;
/* 178 */     return "const vec2 screen = vec2(" + w + "," + h + ");" + "\n";
/*     */   }
/*     */   
/*     */   protected void setUniform2f(int loc, float a, float b) {
/* 182 */     GL20.glUniform2f(loc, a, b);
/*     */   }
/*     */   
/*     */   protected void setUniform(int loc, float a) {
/* 186 */     GL20.glUniform1f(loc, a);
/*     */   }
/*     */   
/*     */   protected void setUniform(int loc, float a, float b, float c) {
/* 190 */     GL20.glUniform3f(loc, a, b, c);
/*     */   }
/*     */   
/*     */   public void setUniform1i(String name, int a) {
/* 194 */     GL20.glUniform1i(getUniformLocation(name), a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Shader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */