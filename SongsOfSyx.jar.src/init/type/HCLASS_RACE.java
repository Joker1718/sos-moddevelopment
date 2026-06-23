/*     */ package init.type;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class HCLASS_RACE
/*     */   implements BOOSTABLE_O, MAPPED {
/*     */   public final int index;
/*     */   public final HCLASS cl;
/*     */   public final Race race;
/*     */   private final int fi;
/*     */   private final String key;
/*     */   public final SPRITE icon;
/*     */   public final String name;
/*     */   private static RClasses all;
/*     */   private static RMAPS<HCLASS_RACE> MAP;
/*     */   
/*     */   private HCLASS_RACE(int index, final HCLASS cl, final Race race) {
/*  33 */     this.index = index;
/*  34 */     this.cl = cl;
/*  35 */     this.race = race;
/*  36 */     this.fi = -1;
/*  37 */     this.key = ((cl == null) ? "NULL" : cl.key) + "_" + ((cl == null) ? "NULL" : cl.key);
/*     */     
/*  39 */     if (race == null && cl == null) {
/*  40 */       this.name = String.valueOf(Dic.¤¤All);
/*  41 */       this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  45 */             double scale = (Y2 - Y1) / height();
/*  46 */             (UI.icons()).s.human.renderCScaled(rr, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2, (int)scale);
/*     */           }
/*     */         };
/*     */     
/*     */     }
/*  51 */     else if (race == null) {
/*     */       
/*  53 */       this.name = String.valueOf(cl.names) + " (" + String.valueOf(cl.names) + ")";
/*     */       
/*  55 */       this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  59 */             double scale = (Y2 - Y1) / height();
/*  60 */             cl.iconSmall().renderCScaled(rr, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2, (int)scale);
/*     */           }
/*     */         };
/*     */     
/*     */     }
/*  65 */     else if (cl == null) {
/*     */       
/*  67 */       this.name = String.valueOf(race.info.names) + " (" + String.valueOf(race.info.names) + ")";
/*  68 */       this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  72 */             double scale = (Y2 - Y1) / height();
/*  73 */             (race.appearance()).icon.renderCScaled(rr, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2, (int)scale);
/*     */           }
/*     */         };
/*     */     } else {
/*     */       
/*  78 */       this.name = String.valueOf(race.info.names) + " (" + String.valueOf(race.info.names) + ")";
/*  79 */       this.icon = (SPRITE)new SPRITE.Imp(36, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER rr, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  83 */             double scale = (Y2 - Y1) / height();
/*  84 */             int x2 = (int)(X1 + (race.appearance()).icon.width() * scale);
/*  85 */             (race.appearance()).icon.render(rr, X1, x2, Y1, (int)(Y1 + (race.appearance()).icon.height() * scale));
/*  86 */             x2 = (int)(x2 - 6.0D * scale);
/*  87 */             cl.iconSmall().render(rr, x2, (int)(x2 + cl.iconSmall().width() * scale), Y1, (int)(Y1 + cl.iconSmall().width() * scale));
/*     */           }
/*     */         };
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
/*     */   public FactionNPC f() {
/* 101 */     if (this.fi == -1)
/* 102 */       return null; 
/* 103 */     return (FactionNPC)FACTIONS.getByIndex(this.fi);
/*     */   }
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 108 */     return v.vGet(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 113 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 118 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     return "POP_CL : " + String.valueOf(this.cl) + " " + String.valueOf(this.race);
/*     */   }
/*     */   
/*     */   public static HCLASS_RACE clP() {
/* 127 */     return all.classes[0][0];
/*     */   }
/*     */   
/*     */   public static HCLASS_RACE clP(Induvidual i) {
/* 131 */     return clP(i.race(), i.clas());
/*     */   }
/*     */   
/*     */   public static HCLASS_RACE clP(Race race) {
/* 135 */     int ci = 0;
/* 136 */     int ri = (race == null) ? 0 : (race.index + 1);
/* 137 */     return all.classes[ci][ri];
/*     */   }
/*     */ 
/*     */   
/*     */   public static HCLASS_RACE clP(HCLASS clas) {
/* 142 */     int ci = (clas == null) ? 0 : (clas.index() + 1);
/* 143 */     int ri = 0;
/* 144 */     return all.classes[ci][ri];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static HCLASS_RACE clP(Race race, HCLASS clas) {
/* 150 */     int ci = (clas == null) ? 0 : (clas.index() + 1);
/* 151 */     int ri = (race == null) ? 0 : (race.index + 1);
/* 152 */     return all.classes[ci][ri];
/*     */   }
/*     */   
/*     */   public static RMAPS<HCLASS_RACE> MAP() {
/* 156 */     return MAP;
/*     */   }
/*     */   
/*     */   public static LIST<HCLASS_RACE> ALL() {
/* 160 */     return (LIST<HCLASS_RACE>)all.all;
/*     */   }
/*     */   
/*     */   public static LIST<HCLASS_RACE> REAL() {
/* 164 */     return (LIST<HCLASS_RACE>)all.real;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void init(HCLASSES cl, RACES races) {
/* 171 */     all = new RClasses(RACES.all());
/* 172 */     MAP = new RMAPS("POPCL", (LIST)all.all);
/*     */   }
/*     */   
/*     */   private static final class RClasses
/*     */   {
/*     */     private final HCLASS_RACE[][] classes;
/*     */     private final ArrayList<HCLASS_RACE> all;
/* 179 */     private final ArrayListGrower<HCLASS_RACE> real = new ArrayListGrower();
/*     */ 
/*     */     
/*     */     RClasses(LIST<Race> all) {
/* 183 */       this.all = new ArrayList((all.size() + 1) * (all.size() + 1));
/* 184 */       this.classes = new HCLASS_RACE[HCLASSES.ALL().size() + 1][all.size() + 1];
/*     */ 
/*     */       
/* 187 */       this.classes[0][0] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), null, null));
/* 188 */       for (Race r : all) {
/* 189 */         this.classes[0][r.index + 1] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), null, r));
/*     */       }
/*     */       
/* 192 */       for (HCLASS cl : HCLASSES.ALL()) {
/* 193 */         this.classes[cl.index() + 1][0] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), cl, null));
/* 194 */         for (Race r : all) {
/* 195 */           this.classes[cl.index() + 1][r.index + 1] = (HCLASS_RACE)this.all.addReturn(new HCLASS_RACE(this.all.size(), cl, r));
/*     */         }
/*     */       } 
/*     */       
/* 199 */       for (HCLASS_RACE cl : this.all) {
/* 200 */         if (cl.cl != null && cl.race != null)
/* 201 */           this.real.add(cl); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HCLASS_RACE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */