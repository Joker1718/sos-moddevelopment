/*     */ package tools.techgen;
/*     */ 
/*     */ import java.io.File;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ class BuilderTree
/*     */ {
/*  12 */   public ArrayListGrower<Node> current = new ArrayListGrower();
/*  13 */   private ArrayListGrower<ArrayListGrower<Node>> nodes = new ArrayListGrower();
/*     */   
/*     */   private final String key;
/*  16 */   private int yy = 0;
/*     */   BuilderTree(String key) {
/*  18 */     this.key = key;
/*  19 */     this.nodes.add(this.current);
/*     */   }
/*     */   
/*     */   public void newLeft() {
/*  23 */     this.current = new ArrayListGrower();
/*  24 */     skip(this.yy);
/*  25 */     ArrayListGrower<ArrayListGrower<Node>> nn = new ArrayListGrower();
/*  26 */     nn.add(this.current);
/*  27 */     for (ArrayListGrower<Node> n : this.nodes)
/*  28 */       nn.add(n); 
/*  29 */     this.nodes = nn;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void newRight() {
/*  35 */     int i = this.nodes.firstIndexOf(this.current);
/*  36 */     if (i >= this.nodes.size() - 1) {
/*  37 */       this.current = new ArrayListGrower();
/*  38 */       this.nodes.add(this.current);
/*  39 */       skip(this.yy);
/*     */     } 
/*  41 */     this.current = (ArrayListGrower<Node>)this.nodes.get(i + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void newLevel() {
/*  47 */     for (LIST<Node> nn : this.nodes)
/*  48 */       this.yy = Math.max(this.yy, nn.size()); 
/*  49 */     for (ArrayListGrower<Node> nn : this.nodes) {
/*  50 */       this.current = nn;
/*  51 */       if (this.current.size() < this.yy) {
/*  52 */         skip(this.yy - this.current.size());
/*     */       }
/*     */     } 
/*  55 */     this.current = (ArrayListGrower<Node>)this.nodes.get(0);
/*     */   }
/*     */   
/*     */   public void newLine() {
/*  59 */     newLevel();
/*     */     
/*  61 */     for (ArrayListGrower<Node> nn : this.nodes) {
/*  62 */       nn.add(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void skip() {
/*  67 */     this.current.add(null);
/*     */   }
/*     */   
/*     */   public void skip(int am) {
/*  71 */     for (int i = 0; i < am; i++)
/*  72 */       this.current.add(null); 
/*     */   }
/*     */   
/*     */   public void add(LIST<Node> nodes) {
/*  76 */     this.current.add((Iterable)nodes);
/*     */   }
/*     */   
/*     */   public Node add(Node node) {
/*  80 */     this.current.add(node);
/*  81 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonE build(int cat, String col, String icon) {
/*  88 */     boolean has = true;
/*  89 */     int i = 0;
/*  90 */     String stree = "{\r\n";
/*  91 */     while (has) {
/*  92 */       has = false;
/*  93 */       String line = "\t" + String.format("%02d", new Object[] { Integer.valueOf(i) }) + ": [";
/*  94 */       for (LIST<Node> nn : this.nodes) {
/*  95 */         String k = "______,";
/*  96 */         if (i < nn.size()) {
/*  97 */           if (nn.get(i) != null)
/*  98 */             k = ((Node)nn.get(i)).key + ","; 
/*  99 */           has = true;
/*     */         } 
/* 101 */         line = line + line;
/*     */       } 
/*     */       
/* 104 */       line = line + "],\r\n";
/* 105 */       if (has)
/* 106 */         stree = stree + stree; 
/* 107 */       i++;
/*     */     } 
/* 109 */     stree = stree + "}";
/*     */ 
/*     */     
/* 112 */     JsonE data = new JsonE();
/* 113 */     for (LIST<Node> nn : this.nodes) {
/* 114 */       for (Node n : nn) {
/* 115 */         if (n != null) {
/* 116 */           data.add(n.key, n.json());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     JsonE j = new JsonE();
/*     */ 
/*     */     
/* 124 */     j.add("CATEGORY", cat);
/* 125 */     j.add("COLOR", col);
/* 126 */     j.add("ICON", icon);
/* 127 */     j.add("TREE", stree);
/* 128 */     j.add("TECHS", data);
/*     */     
/* 130 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonE buildText(String name) {
/* 137 */     JsonE j = new JsonE();
/* 138 */     j.addString("NAME", name);
/* 139 */     JsonE text = new JsonE();
/*     */     
/* 141 */     Json names = null;
/* 142 */     if (this.key != null) {
/* 143 */       Json n = new Json((new File(String.valueOf((new File("")).getAbsoluteFile()) + "\\tool\\techTrees\\DESC.txt")).toPath());
/* 144 */       if (n.has(this.key)) {
/* 145 */         names = n.json(this.key);
/*     */       }
/*     */     } 
/* 148 */     for (LIST<Node> nn : this.nodes) {
/*     */       
/* 150 */       for (Node n : nn) {
/* 151 */         if (n != null) {
/* 152 */           JsonE t = new JsonE();
/* 153 */           if (names != null && names.has(n.key)) {
/* 154 */             String s = names.json(n.key).text("NAME");
/* 155 */             if (s.length() > 0)
/* 156 */               n.name = s; 
/* 157 */             s = names.json(n.key).text("DESC");
/* 158 */             if (s.length() > 0) {
/* 159 */               n.desc = s;
/*     */             }
/*     */           } 
/* 162 */           t.addString("NAME", n.name);
/* 163 */           t.addString("DESC", n.desc);
/* 164 */           text.add(n.key, t);
/*     */         } 
/*     */       } 
/* 167 */     }  j.add("TECHS", text);
/* 168 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(int cat, String icon, String col, String name) {
/* 175 */     JsonE data = build(cat, col, icon);
/* 176 */     File file = new File((new File("")).getAbsolutePath() + "\\zipdata\\data\\assets\\init\\tech\\" + (new File("")).getAbsolutePath() + ".txt");
/* 177 */     data.save(file.toPath());
/*     */     
/* 179 */     data = buildText(name);
/* 180 */     file = new File((new File("")).getAbsolutePath() + "\\zipdata\\data\\assets\\text\\tech\\" + (new File("")).getAbsolutePath() + ".txt");
/* 181 */     data.save(file.toPath());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\techgen\BuilderTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */