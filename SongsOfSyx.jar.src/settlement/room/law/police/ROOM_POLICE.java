/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEAN;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class ROOM_POLICE
/*     */   extends RoomBlueprintIns<PoliceInstance> {
/*     */   final PoliceConstructor constructor;
/*  40 */   private final ArrayListGrower<BOOLEAN.BOOLEANImp> access = new ArrayListGrower();
/*     */   
/*  42 */   public final PoliceWork work = new PoliceWork(this);
/*     */   
/*     */   public final BoostSpecs spec;
/*     */ 
/*     */   
/*     */   public ROOM_POLICE(RoomInitData init, RoomCategorySub block) throws IOException {
/*  48 */     super(0, init, "_POLICE", block);
/*     */     
/*  50 */     for (int i = 0; i < HCLASS_RACE.ALL().size(); i++) {
/*  51 */       this.access.add(new BOOLEAN.BOOLEANImp((((HCLASS_RACE)HCLASS_RACE.ALL().get(i)).cl == HCLASSES.SLAVE())));
/*     */     }
/*  53 */     this.constructor = new PoliceConstructor(this, init);
/*     */     
/*  55 */     BValue v = new BValue()
/*     */       {
/*  57 */         private int[] upIs = Alloc.ii(HCLASS_RACE.ALL().size());
/*  58 */         private double[] vv = new double[HCLASS_RACE.ALL().size()];
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/*  62 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/*  67 */           return vGet(HCLASS_RACE.clP());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE cl) {
/*  74 */           if (this.upIs[cl.index] != GAME.updateI()) {
/*  75 */             this.upIs[cl.index] = GAME.updateI();
/*  76 */             if (cl.cl == null) {
/*  77 */               double pop = 0.0D;
/*  78 */               double v = 0.0D;
/*  79 */               for (int ci = 0; ci < HCLASSES.ALLP().size(); ci++) {
/*  80 */                 double p = POP.pop((HCLASS)HCLASSES.ALLP().get(ci), cl.race);
/*  81 */                 pop += p;
/*  82 */                 v += p * vGet(HCLASS_RACE.clP(cl.race, (HCLASS)HCLASSES.ALLP().get(ci)));
/*     */               } 
/*  84 */               if (pop == 0.0D)
/*  85 */               { this.vv[cl.index] = 0.0D; }
/*     */               else
/*  87 */               { this.vv[cl.index] = v / pop; } 
/*  88 */             } else if (cl.race == null) {
/*  89 */               double pop = 0.0D;
/*  90 */               double v = 0.0D;
/*  91 */               for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  92 */                 double p = POP.pop(cl.cl, (Race)RACES.all().get(ri));
/*  93 */                 pop += p;
/*  94 */                 v += p * vGet(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl));
/*     */               } 
/*  96 */               if (pop == 0.0D) {
/*  97 */                 this.vv[cl.index] = 0.0D;
/*     */               } else {
/*  99 */                 this.vv[cl.index] = v / pop;
/*     */               } 
/* 101 */             } else if (!((BOOLEAN.BOOLEANImp)ROOM_POLICE.this.access.get(cl.index())).is()) {
/* 102 */               this.vv[cl.index] = 0.0D;
/*     */             } else {
/* 104 */               this.vv[cl.index()] = ROOM_POLICE.this.value();
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 112 */           return this.vv[cl.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Div div) {
/* 117 */           return vGet(HCLASS_RACE.clP(div.race(), HCLASSES.CITIZEN()));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu) {
/* 122 */           return vGet(indu.popCL());
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Region reg) {
/* 127 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 131 */     this.spec = new BoostSpecs(new BSourceInfo(this.info.name, (SPRITE)this.icon), true);
/* 132 */     this.spec.read(init.data(), v);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 145 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/* 150 */     HCLASS_RACE.MAP().saver().save((LIST)this.access, f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/* 155 */     HCLASS_RACE.MAP().loader().load((LIST)this.access, f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 160 */     for (BOOLEAN.BOOLEANImp b : this.access) {
/* 161 */       b.set(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 171 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public BOOLEAN.BOOLEAN_MUTABLE access(HCLASS_RACE g) {
/* 176 */     return (BOOLEAN.BOOLEAN_MUTABLE)this.access.get(g.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public double value() {
/* 181 */     double pop = 0.0D;
/* 182 */     for (HCLASS_RACE r : HCLASS_RACE.ALL()) {
/* 183 */       if (((BOOLEAN.BOOLEANImp)this.access.get(r.index)).is()) {
/* 184 */         pop += (STATS.POP()).POP.data(r.cl).get(r.race);
/*     */       }
/*     */     } 
/* 187 */     if (pop == 0.0D) {
/* 188 */       return ((employment().employed() > 0) ? true : false);
/*     */     }
/* 190 */     return Math.sqrt(CLAMP.d(employment().employed() / pop, 0.0D, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(HCLASS cl, Race race) {
/* 195 */     if (!((BOOLEAN.BOOLEANImp)this.access.get((HCLASS_RACE.clP(race, cl)).index)).is()) {
/* 196 */       return 0.0D;
/*     */     }
/* 198 */     double pop = 0.0D;
/* 199 */     for (HCLASS_RACE r : HCLASS_RACE.ALL()) {
/* 200 */       if (((BOOLEAN.BOOLEANImp)this.access.get(r.index)).is()) {
/* 201 */         pop += (STATS.POP()).POP.data(r.cl).get(r.race);
/*     */       }
/*     */     } 
/* 204 */     if (pop == 0.0D) {
/* 205 */       return ((employment().employed() > 0) ? true : false);
/*     */     }
/* 207 */     return Math.sqrt(CLAMP.d(employment().employed() / pop, 0.0D, 1.0D));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\ROOM_POLICE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */