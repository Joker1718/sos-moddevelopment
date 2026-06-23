/*     */ package settlement.room.water;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ final class PumpGui extends UIRoomModule.UIRoomModuleImp<PumpInstance, ROOM_PUMP> {
/*  21 */   private static CharSequence ¤¤Preasure = "Pressure (pump)";
/*  22 */   private static CharSequence ¤¤PreasureS = "Pressure (connected system)";
/*  23 */   private static CharSequence ¤¤PreasureD = "Pressure is created through pumps. The workers in pumps, and their degrade determine the current pressure.";
/*     */   
/*     */   static {
/*  26 */     D.ts(PumpGui.class);
/*     */   }
/*     */   
/*     */   public PumpGui(ROOM_PUMP blueprint) {
/*  30 */     super(blueprint);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, PumpInstance ins) {
/*  36 */     box.NL();
/*  37 */     box.textLL(¤¤Preasure);
/*  38 */     box.add((SPRITE)GFORMAT.iofkInv(box.text(), ins.value, (int)ins.valueMax));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid g, final GETTER<PumpInstance> getter, int x1, int y1) {
/*  54 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  58 */             PumpInstance ins = (PumpInstance)getter.get();
/*  59 */             GFORMAT.iofkInv(text, ins.value, (int)ins.valueMax);
/*     */           }
/*  61 */         }).hv(¤¤Preasure, ¤¤PreasureD));
/*     */     
/*  63 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  67 */             PumpInstance ins = (PumpInstance)getter.get();
/*  68 */             int tx = ins.ox();
/*  69 */             int ty = ins.oy();
/*  70 */             PumpGui.hoverSystem(text, tx, ty);
/*     */           }
/*  72 */         }).hv(¤¤PreasureS, ¤¤PreasureD));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hoverSystem(GBox box, int tx, int ty) {
/*  77 */     GText t = box.text();
/*  78 */     hoverSystem(t, tx, ty);
/*     */     
/*  80 */     box.textLL(¤¤PreasureS);
/*  81 */     box.NL();
/*  82 */     box.add((SPRITE)t);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void hoverSystem(GText text, int tx, int ty) {
/*  88 */     int current = 0;
/*  89 */     double needed = 0.0D;
/*     */     
/*  91 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  92 */     f.init(PumpGui.class);
/*  93 */     f.pushSloppy(tx, ty, 0.0D);
/*  94 */     ROOM_WATER w = (SETT.ROOMS()).WATER;
/*  95 */     while (f.hasMore()) {
/*  96 */       PathTile t = f.pollSmallest();
/*  97 */       RoomPumpable p = (RoomPumpable)w.pumpable.get(t.x(), t.y());
/*  98 */       if (p != null) {
/*  99 */         needed += p.suckAmount(t.x(), t.y());
/*     */         
/* 101 */         if (p.radius() > 0) {
/* 102 */           int rr = p.radius();
/* 103 */           int i = 0;
/* 104 */           while (GUTIL.circle().radius(i) < rr) {
/*     */             
/* 106 */             int dx = GUTIL.circle().get(i).x() + t.x();
/* 107 */             int dy = GUTIL.circle().get(i).y() + t.y();
/* 108 */             if (w.pumpable.get(dx, dy) == p) {
/* 109 */               f.pushSmaller(dx, dy, (t.getValue() + GUTIL.circle().radius(i)), t);
/*     */             }
/*     */             
/* 112 */             i++;
/*     */           } 
/* 114 */           needed += p.radius();
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 120 */         PumpInstance ins = (PumpInstance)w.pump.get(t.x(), t.y());
/* 121 */         if (ins != null && ins.ox() == t.x() && ins.oy() == t.y()) {
/* 122 */           current += ins.value;
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       } 
/*     */       
/* 128 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 129 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 130 */         if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */         {
/*     */           
/* 133 */           if (p == null || w.pumpable.get((COORDINATE)t, d) == null || p.pumpsTo(t.x(), t.y(), t.x() + d.x(), t.y() + d.y()))
/*     */           {
/*     */             
/* 136 */             f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     f.done();
/*     */     
/* 144 */     GFORMAT.iofkInv(text, current, (int)needed);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\PumpGui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */