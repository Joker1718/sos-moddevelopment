/*     */ package settlement.room.spirit.dump;
/*     */ 
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class DumpInstance extends RoomInstance implements ROOM_SERVICER {
/*     */   private final RoomServiceInstance service;
/*     */   
/*     */   protected DumpInstance(ROOM_DUMP blueprint, TmpArea area, RoomInit init) {
/*  22 */     super(blueprint, area, init);
/*  23 */     int am = 0;
/*  24 */     for (COORDINATE c : body()) {
/*  25 */       if (is(c) && 
/*  26 */         !(blueprintI()).constructor.isEdge(c.x(), c.y(), (AREA)this)) {
/*  27 */         Dump.init(this, c.x(), c.y());
/*  28 */         am++;
/*     */       } 
/*     */     } 
/*     */     
/*  32 */     this.service = new RoomServiceInstance(am, blueprint.service());
/*  33 */     activate();
/*     */   }
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public ROOM_DUMP blueprintI() {
/*  39 */     return (ROOM_DUMP)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activateAction() {
/*  44 */     for (COORDINATE c : body()) {
/*  45 */       if (is(c)) {
/*  46 */         Dump.activate(c.x(), c.y());
/*     */       }
/*     */     } 
/*  49 */     this.service.clearLoad();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {
/*  55 */     for (COORDINATE c : body()) {
/*  56 */       if (is(c)) {
/*  57 */         Dump.deactivate(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  65 */     this.service.dispose((blueprintI()).service);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  71 */     Dump.render(r, shadowBatch, i);
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  77 */     (blueprintI()).constructor.renderTileBelow((SPRITE_RENDERER)r, shadowBatch, i, true);
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  83 */     if (day) {
/*  84 */       this.service.updateDay();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/*  89 */     Dump d = Dump.get(tx, ty);
/*  90 */     if (d != null) {
/*  91 */       d.update();
/*     */     }
/*     */   }
/*     */   
/*     */   public RoomServiceInstance service() {
/*  96 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 101 */     return ROOM_SERVICER.defQuality(this, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canRemoveAndRemoveAction(int tx, int ty, boolean scatter, Object obj, boolean force) {
/* 106 */     if (force || !prompt())
/* 107 */       return true; 
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   private boolean prompt() {
/* 112 */     int time = 0;
/* 113 */     int am = 0;
/* 114 */     for (COORDINATE c : body()) {
/* 115 */       if (is(c)) {
/* 116 */         int t = Dump.daysTillDecompose(c.x(), c.y());
/* 117 */         if (t > 0) {
/* 118 */           am++;
/* 119 */           if (t > time) {
/* 120 */             time = t;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 125 */     if (am > 0) {
/* 126 */       Str.TMP.clear();
/* 127 */       Str.TMP.add(ROOM_DUMP.¤¤RemoveProblem);
/* 128 */       Str.TMP.insert(0, am);
/* 129 */       Str.TMP.insert(1, time);
/* 130 */       (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, null, null, false);
/* 131 */       return true;
/*     */     } 
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\dump\DumpInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */