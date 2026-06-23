/*     */ package settlement.stats.service;
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class StatServiceChild extends StatServiceImp {
/*  31 */   private static CharSequence ¤¤children = "Children (with access)";
/*  32 */   private static CharSequence ¤¤access = "Child Access"; private final STATData access;
/*     */   
/*     */   static {
/*  35 */     D.ts(StatServiceChild.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final STAT stat;
/*     */   
/*     */   public final RoomBlueprintIns<?> blue;
/*     */   public final RoomService.ROOM_SERVICE_HASER blueS;
/*     */   
/*     */   StatServiceChild(LISTE<StatServiceImp> all, RoomBlueprintIns<?> ho, StatsInit init) {
/*  45 */     super(ho.key, all, init, ho.info.name, ho.info.desc, (SPRITE)ho.icon, null);
/*     */     
/*  47 */     if (!(ho instanceof RoomService.ROOM_SERVICE_HASER)) {
/*  48 */       throw new RuntimeException(String.valueOf(ho) + " " + String.valueOf(ho));
/*     */     }
/*  50 */     this.blue = ho;
/*  51 */     this.blueS = (RoomService.ROOM_SERVICE_HASER)ho;
/*     */     
/*  53 */     this.access = new STATData(null, ho.key + "access", init, (INT_O.INT_OE)new DataO.DataBit(init.count, ho.key + "access"));
/*     */     
/*  55 */     this.stat = (STAT)new STATFakeData(ho.key, ho.key + "D", init, new StatInfo(ho.info.name, ho.info.desc))
/*     */       {
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type)
/*     */         {
/*  59 */           GBox b = (GBox)text;
/*     */ 
/*     */           
/*  62 */           b.NL();
/*  63 */           b.textL(StatServiceChild.¤¤children);
/*  64 */           b.tab(6);
/*  65 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)children()));
/*  66 */           b.NL();
/*  67 */           b.textL(StatServiceChild.¤¤access);
/*  68 */           b.tab(6);
/*  69 */           b.add((SPRITE)GFORMAT.i(b.text(), StatServiceChild.this.blueS.service().total()));
/*  70 */           b.NL();
/*     */           
/*  72 */           b.textL(Dic.¤¤Value);
/*  73 */           b.tab(6);
/*  74 */           b.add((SPRITE)GFORMAT.perc(b.text(), getDD(cl, type)));
/*  75 */           b.NL();
/*     */           
/*  77 */           super.hover(text, cl, type);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, Induvidual indu) {
/*  82 */           hover(text, indu.clas(), indu.race());
/*     */         }
/*     */         
/*  85 */         double totChildren = 0.0D;
/*  86 */         int updateI = -1;
/*     */ 
/*     */         
/*     */         protected double getDD(HCLASS cl, Race r) {
/*  90 */           if (!StatServiceChild.this.permission().is(HCLASS_RACE.clP(r, cl)))
/*  91 */             return 0.0D; 
/*  92 */           double tot = StatServiceChild.this.blueS.service().total();
/*  93 */           if (tot <= 0.0D) {
/*  94 */             return 0.0D;
/*     */           }
/*  96 */           return CLAMP.d(tot / children(), 0.0D, 1.0D);
/*     */         }
/*     */         
/*     */         private double children() {
/* 100 */           if (this.updateI != GAME.updateI()) {
/* 101 */             this.updateI = GAME.updateI();
/* 102 */             this.totChildren = 0.0D;
/* 103 */             for (Race ra : RACES.all()) {
/* 104 */               if (StatServiceChild.this.permission().is(HCLASS_RACE.clP(ra, HCLASSES.CITIZEN())))
/* 105 */                 this.totChildren += STATS.POP().pop(ra, HTYPES.CHILD()); 
/* 106 */               if (StatServiceChild.this.permission().is(HCLASS_RACE.clP(ra, HCLASSES.SLAVE()))) {
/* 107 */                 this.totChildren += STATS.POP().pop(ra, HTYPES.CHILD_SLAVE());
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 112 */           return this.totChildren;
/*     */         }
/*     */       };
/* 115 */     (this.stat.info()).icon = ho.icon.resized(16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accessRequest(Humanoid h) {
/* 121 */     if (h.indu().hType().parent() != h.indu().hType()) {
/* 122 */       return permission().is(HCLASS_RACE.clP(h.race(), h.indu().hType().parent().parentClass()));
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean access(Humanoid h) {
/* 129 */     return (this.stat.indu().getD(h.indu()) >= 0.0D);
/*     */   }
/*     */   
/*     */   public void setAccess(Humanoid h, boolean is) {
/* 133 */     this.access.indu().set(h.indu(), is ? 1 : 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT total() {
/* 138 */     return this.stat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearAccess(Induvidual i) {
/* 143 */     this.access.indu().set(i, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cheatSetTotal(Induvidual i, double tot) {
/* 148 */     this.access.indu().set(i, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceChild.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */