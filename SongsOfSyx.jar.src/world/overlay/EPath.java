/*     */ package world.overlay;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import world.map.pathing.WPATHING;
/*     */ import world.map.pathing.WPath;
/*     */ import world.map.pathing.WRegFinder;
/*     */ 
/*     */ public final class EPath {
/*  19 */   private final double dist = 4.0D;
/*     */   
/*     */   private WRegFinder.Treaty treaty;
/*     */   
/*  23 */   private WPath path = new WPath()
/*     */     {
/*     */       public WRegFinder.Treaty treaty()
/*     */       {
/*  27 */         return EPath.this.treaty;
/*     */       }
/*     */     };
/*     */   
/*  31 */   private Coo start = new Coo();
/*  32 */   private Coo end = new Coo();
/*     */   private boolean newPath = true;
/*  34 */   private final Rec rr = new Rec(64.0D);
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean added = false;
/*     */ 
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch s, RenderData data) {
/*  43 */     if (!this.added) {
/*     */       return;
/*     */     }
/*  46 */     this.added = false;
/*     */ 
/*     */     
/*  49 */     this.path.find(this.start.x(), this.start.y(), this.end.x(), this.end.y());
/*  50 */     if (!this.path.isValid()) {
/*     */       return;
/*     */     }
/*     */     
/*  54 */     if (this.newPath) {
/*  55 */       this.newPath = false;
/*     */     }
/*  57 */     COLOR.WHITE100.bind();
/*     */     
/*  59 */     double move = VIEW.renderSecond() % 4.0D;
/*     */     
/*  61 */     int prevx = this.path.x() * 64;
/*  62 */     int prevy = this.path.y() * 64;
/*  63 */     if (!this.path.setNext()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  70 */       int x = this.path.x() * 64;
/*  71 */       int y = this.path.y() * 64;
/*     */       
/*  73 */       double md = 0.5D / this.path.dir().tileDistance() * WPATHING.movementSpeed(this.path.x(), this.path.y());
/*     */       
/*  75 */       move -= md;
/*     */       
/*  77 */       if (move < 0.0D) {
/*     */ 
/*     */         
/*  80 */         double dd = move / md;
/*  81 */         move += 4.0D;
/*  82 */         int dx = (int)((x - prevx) * dd);
/*  83 */         int dy = (int)((y - prevy) * dd);
/*     */         
/*  85 */         DIR d = DIR.get(prevx, prevy, x, y);
/*  86 */         COLOR.YELLOW100.bind();
/*  87 */         ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render((SPRITE_RENDERER)r, data.transformGX(x + dx), data.transformGY(y + dy));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*  92 */       prevx = x;
/*  93 */       prevy = y;
/*     */ 
/*     */       
/*  96 */       COLOR.WHITE100.bind();
/*  97 */       x = data.transformGX(x);
/*  98 */       y = data.transformGY(y);
/*  99 */       (SPRITES.cons()).BIG.line.render((SPRITE_RENDERER)r, 0, x, y);
/* 100 */     } while (this.path.setNext());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int sx, int sy, int dx, int dy, WRegFinder.Treaty treaty) {
/* 110 */     this.newPath |= this.start.set(sx, sy);
/* 111 */     this.newPath |= this.end.set(dx, dy);
/* 112 */     this.treaty = treaty;
/* 113 */     if (this.newPath) {
/* 114 */       this.path.find(this.start.x(), this.start.y(), this.end.x(), this.end.y());
/* 115 */       this.rr.moveC((sx * 64 + 32), (sy * 64 + 32));
/*     */     } 
/* 117 */     this.added = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\EPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */