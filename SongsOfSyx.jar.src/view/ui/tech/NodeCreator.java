/*     */ package view.ui.tech;
/*     */ 
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechTree;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class NodeCreator
/*     */ {
/*     */   static final int DIM = 32;
/*     */   public final LIST<RENDEROBJ> rows;
/*     */   private final MAP_OBJECT<RENDEROBJ> map;
/*     */   private final RECTANGLE bounds;
/*     */   
/*     */   NodeCreator(TechTree tree) {
/*  31 */     final RENDEROBJ[][] res = create(tree);
/*  32 */     this.bounds = (RECTANGLE)new Rec((res[0]).length, res.length);
/*  33 */     this.map = new MAP_OBJECT<RENDEROBJ>()
/*     */       {
/*     */         public RENDEROBJ get(int tx, int ty)
/*     */         {
/*  37 */           if (NodeCreator.this.bounds.holdsPoint(tx, ty))
/*  38 */             return res[ty][tx]; 
/*  39 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RENDEROBJ get(int tile) {
/*  44 */           return null;
/*     */         }
/*     */       };
/*  47 */     path();
/*  48 */     ArrayList<RENDEROBJ> rows = new ArrayList(res.length);
/*  49 */     for (int i = 0; i < res.length - 1; i += 2) {
/*  50 */       GuiSection s = new GuiSection();
/*  51 */       for (int x = 0; x < (res[i]).length; x++) {
/*  52 */         s.add(res[i][x], s.body().x2(), 0);
/*  53 */         s.add(res[i + 1][x], s.getLast().x1(), s.getLastY2());
/*     */       } 
/*  55 */       rows.add(s);
/*     */     } 
/*  57 */     this.rows = (LIST<RENDEROBJ>)rows;
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ[][] create(TechTree tree) {
/*  62 */     int w = 0; byte b; int i; TECH[][] arrayOfTECH;
/*  63 */     for (i = (arrayOfTECH = tree.nodes).length, b = 0; b < i; ) { TECH[] n = arrayOfTECH[b];
/*  64 */       w = Math.max(w, n.length); b++; }
/*  65 */      NodeBoosts boosts = new NodeBoosts();
/*  66 */     RENDEROBJ[][] res = new RENDEROBJ[tree.nodes.length * 2 + 1][w * 2];
/*     */     
/*     */     int y;
/*  69 */     for (y = 0; y < tree.nodes.length; y++) {
/*  70 */       for (int j = 0; j < (tree.nodes[y]).length; j++) {
/*  71 */         if (tree.nodes[y][j] != null)
/*  72 */           res[y * 2][j * 2] = (RENDEROBJ)new Node(tree.nodes[y][j], boosts); 
/*     */       } 
/*     */     } 
/*  75 */     for (y = 0; y < res.length; y++) {
/*  76 */       for (int j = 0; j < (res[y]).length; j++) {
/*  77 */         if (res[y][j] == null) {
/*  78 */           int wi = ((j & 0x1) == 1) ? 32 : 80;
/*  79 */           int hi = ((y & 0x1) == 1) ? 32 : Node.HEIGHT();
/*  80 */           res[y][j] = (RENDEROBJ)new Edge(wi, hi);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  86 */     for (y = 0; y < res.length; y++) {
/*  87 */       boolean clear = true; int j;
/*  88 */       for (j = 0; j < (res[y]).length; j++) {
/*  89 */         if (res[y][j] instanceof Node) {
/*  90 */           clear = false;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  95 */       if (clear) {
/*  96 */         for (j = 0; j < (res[y]).length; j++) {
/*  97 */           RENDEROBJ o = res[y][j];
/*  98 */           if (o.body().height() != 32) {
/*  99 */             res[y][j] = (RENDEROBJ)new Edge(o.body().width(), 32);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 105 */     for (int x = 0; x < (res[0]).length; x++) {
/* 106 */       boolean clear = true; int j;
/* 107 */       for (j = 0; j < res.length; j++) {
/* 108 */         if (res[j][x] instanceof Node) {
/* 109 */           clear = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 113 */       if (clear) {
/* 114 */         for (j = 0; j < res.length; j++) {
/* 115 */           RENDEROBJ o = res[j][x];
/* 116 */           if (o.body().width() != 32) {
/* 117 */             res[j][x] = (RENDEROBJ)new Edge(32, o.body().height());
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 125 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void path() {
/* 133 */     Bitmap1D m = new Bitmap1D(TECHS.ALL().size() * TECHS.ALL().size(), false);
/* 134 */     for (COORDINATE c : this.bounds) {
/* 135 */       RENDEROBJ o = (RENDEROBJ)this.map.get(c);
/* 136 */       if (o instanceof Node) {
/* 137 */         Node n = (Node)o;
/* 138 */         m.set(n.tech.index() * TECHS.ALL().size() + n.tech.index(), true);
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     label69: while (true) {
/* 149 */       f.init(this);
/*     */ 
/*     */       
/* 152 */       Node start = null;
/*     */       
/* 154 */       label65: for (COORDINATE c : this.bounds) {
/*     */         
/* 156 */         RENDEROBJ o = (RENDEROBJ)this.map.get(c);
/* 157 */         if (o instanceof Node) {
/* 158 */           Node n = (Node)o;
/* 159 */           for (int i = 0; i < n.tech.requiresNodes().size(); i++) {
/* 160 */             TECH.TechRequirement r = (TECH.TechRequirement)n.tech.requiresNodes().get(i);
/* 161 */             if (!m.get(n.tech.index() * TECHS.ALL().size() + r.tech.index())) {
/* 162 */               start = n;
/* 163 */               f.pushSloppy(c.x(), c.y(), 0.0D);
/* 164 */               f.setValue2(c.x(), c.y(), n.tech.index());
/*     */               
/*     */               break label65;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 172 */       if (start == null) {
/* 173 */         f.done();
/*     */         
/*     */         return;
/*     */       } 
/* 177 */       while (f.hasMore()) {
/* 178 */         PathTile t = f.pollSmallest();
/* 179 */         RENDEROBJ ro = (RENDEROBJ)this.map.get((COORDINATE)t);
/*     */         
/* 181 */         if (ro instanceof Node) {
/* 182 */           Node n = (Node)ro;
/* 183 */           if (!m.get((int)(t.getValue2() * TECHS.ALL().size() + n.tech.index()))) {
/*     */             
/* 185 */             PathTile root = t;
/* 186 */             while (root.getParent() != null)
/* 187 */               root = root.getParent(); 
/* 188 */             Node node = (Node)this.map.get((COORDINATE)root);
/* 189 */             m.set(n.tech.index() * TECHS.ALL().size() + node.tech.index(), true);
/* 190 */             m.set(node.tech.index() * TECHS.ALL().size() + n.tech.index(), true);
/* 191 */             PathTile parent = t;
/* 192 */             t = t.getParent();
/* 193 */             while (t != null) {
/*     */               
/* 195 */               if (this.map.get((COORDINATE)t) instanceof Edge) {
/*     */                 
/* 197 */                 Edge e = (Edge)this.map.get((COORDINATE)t);
/*     */ 
/*     */                 
/* 200 */                 DIR ori = DIR.get((COORDINATE)t, (COORDINATE)parent);
/* 201 */                 int mm = ori.mask();
/*     */ 
/*     */                 
/* 204 */                 if (t.getParent() != null) {
/* 205 */                   mm |= DIR.get((COORDINATE)t, (COORDINATE)t.getParent()).mask();
/*     */                 }
/* 207 */                 if (t.getParent().getParent() == null)
/* 208 */                   e.a |= DIR.get((COORDINATE)t, (COORDINATE)t.getParent()).mask(); 
/* 209 */                 e.m |= mm;
/*     */                 
/* 211 */                 node.addEdge(n, e, mm);
/*     */               } 
/*     */               
/* 214 */               parent = t;
/* 215 */               t = t.getParent();
/*     */             } 
/*     */             
/* 218 */             m.set(n.tech.index(), false);
/* 219 */             f.done();
/*     */             
/*     */             continue label69;
/*     */           } 
/*     */         } 
/* 224 */         for (DIR d : DIR.ORTHO) {
/* 225 */           if (d != DIR.S) {
/* 226 */             push(t.x(), t.y(), d, t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 231 */       for (int ri = 0; ri < start.tech.requiresNodes().size(); ri++) {
/* 232 */         TECH.TechRequirement r = (TECH.TechRequirement)start.tech.requiresNodes().get(ri);
/* 233 */         m.get(start.tech.index() * TECHS.ALL().size() + r.tech.index());
/*     */ 
/*     */ 
/*     */         
/* 237 */         m.set(start.tech.index() * TECHS.ALL().size() + r.tech.index(), true);
/* 238 */         m.set(start.tech.index() + r.tech.index() * TECHS.ALL().size(), true);
/*     */       } 
/* 240 */       f.done();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void push(int dx, int dy, DIR d, PathTile parent) {
/* 253 */     if (!this.bounds.holdsPoint(dx, dy, d))
/*     */       return; 
/* 255 */     double v = 0.0D;
/* 256 */     if (this.map.get(dx, dy) instanceof Edge) {
/*     */       
/* 258 */       Edge e = (Edge)this.map.get(dx, dy);
/* 259 */       if (d.x() != 0) {
/* 260 */         v += (e.body().width() / 2);
/*     */       } else {
/* 262 */         v += (e.body().height() / 2);
/* 263 */       }  if ((e.m & d.mask()) != 0)
/* 264 */         v *= 0.25D; 
/* 265 */     } else if (((Node)this.map.get(dx, dy)).tech.index() != parent.getValue2()) {
/*     */       return;
/* 267 */     }  dx += d.x();
/* 268 */     dy += d.y();
/* 269 */     if (this.map.get(dx, dy) instanceof Edge) {
/*     */       
/* 271 */       Edge e = (Edge)this.map.get(dx, dy);
/* 272 */       if (d.x() != 0) {
/* 273 */         v += (e.body().width() / 2);
/*     */       } else {
/* 275 */         v += (e.body().height() / 2);
/* 276 */       }  if ((e.m & d.mask()) != 0)
/* 277 */         v *= 0.25D; 
/*     */     } else {
/* 279 */       Node n = (Node)this.map.get(dx, dy);
/* 280 */       if (!req(parent, n))
/*     */         return; 
/*     */     } 
/* 283 */     if (parent.getParent() != null && 
/* 284 */       DIR.get((COORDINATE)parent.getParent(), (COORDINATE)parent) != d) {
/* 285 */       v += 8.0D;
/*     */     }
/*     */     
/* 288 */     if (GUTIL.flooder().pushSmaller(dx, dy, v + parent.getValue(), parent) != null) {
/* 289 */       GUTIL.flooder().setValue2(dx, dy, parent.getValue2());
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean req(PathTile t, Node node) {
/* 294 */     TECH p = (TECH)TECHS.ALL().get((int)t.getValue2());
/* 295 */     for (int i = 0; i < p.requiresNodes().size(); i++) {
/* 296 */       if (((TECH.TechRequirement)p.requiresNodes().get(i)).tech == node.tech)
/* 297 */         return true; 
/*     */     } 
/* 299 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\NodeCreator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */