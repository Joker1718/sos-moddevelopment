/*     */ package game.nobility;
/*     */ import game.boosting.Boostable;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.infra.admin.ROOM_ADMIN;
/*     */ import settlement.room.knowledge.laboratory.ROOM_LABORATORY;
/*     */ import settlement.room.knowledge.library.ROOM_LIBRARY;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ class NobleOfficeUtil {
/*  23 */   private static CharSequence ¤¤Governing = "Governor";
/*  24 */   private static CharSequence ¤¤GoverningD = "Gives you {0} gov points to use to develop regions with. Each additional rank yields {1} more points.";
/*     */   
/*  26 */   private static CharSequence ¤¤rBoost = "Boosts {0} workers in your {1} with + {2}. Each additional rank boosts {3} more workers.";
/*  27 */   private static CharSequence ¤¤name = "Master of {0}";
/*     */ 
/*     */   
/*     */   static {
/*  31 */     D.ts(NobleOfficeUtil.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<NobleOffice> make() {
/*  36 */     int workers = 50;
/*  37 */     int gov = 20;
/*     */     
/*  39 */     ArrayListGrower<NobleOffice> all = new ArrayListGrower();
/*  40 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).MINES)
/*  41 */       make(all, m, workers); 
/*  42 */     make(all, (INDUSTRY_HASER)(SETT.ROOMS()).WOOD_CUTTER, workers);
/*  43 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).FARMS)
/*  44 */       make(all, m, workers); 
/*  45 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).ORCHARDS)
/*  46 */       make(all, m, workers); 
/*  47 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).PASTURES)
/*  48 */       make(all, m, workers); 
/*  49 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).FISHERIES)
/*  50 */       make(all, m, workers); 
/*  51 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).REFINERS)
/*  52 */       make(all, m, workers); 
/*  53 */     for (INDUSTRY_HASER m : (SETT.ROOMS()).WORKSHOPS) {
/*  54 */       make(all, m, workers);
/*     */     }
/*  56 */     CharSequence desc = String.valueOf(Str.TMP.clear().add(¤¤GoverningD).insert(0, gov).insert(1, 2 * gov));
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
/*     */ 
/*     */ 
/*     */     
/*  89 */     ((NobleOffice)all.get(all.size() - 1)).special = true;
/*     */     
/*  91 */     make(all, (RoomBlueprintImp)(SETT.ROOMS()).EMBASSY, (SETT.ROOMS()).EMBASSY.bonus(), workers);
/*  92 */     for (ROOM_LIBRARY l : (SETT.ROOMS()).LIBRARIES)
/*  93 */       make(all, (RoomBlueprintImp)l, l.bonus(), workers); 
/*  94 */     for (ROOM_LABORATORY l : (SETT.ROOMS()).LABORATORIES)
/*  95 */       make(all, (RoomBlueprintImp)l, l.bonus(), workers); 
/*  96 */     for (ROOM_ADMIN l : (SETT.ROOMS()).ADMINS) {
/*  97 */       make(all, (RoomBlueprintImp)l, l.bonus(), workers);
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     return (LIST<NobleOffice>)all;
/*     */   }
/*     */   
/*     */   public static void make(ArrayListGrower<NobleOffice> all, INDUSTRY_HASER i, int workers) {
/* 136 */     make(all, ((Industry)i.industries().get(0)).blue, ((Industry)i.industries().get(0)).bonus(), workers);
/*     */   }
/*     */   
/*     */   public static void make(ArrayListGrower<NobleOffice> all, RoomBlueprintImp blue, Boostable bo, int workers) {
/* 140 */     double inc = 2.5D;
/* 141 */     CharSequence desc = String.valueOf(Str.TMP.clear().add(¤¤rBoost).insert(0, workers).insert(1, blue.info.names).insert(2, inc, 1).insert(3, 2 * workers));
/* 142 */     CharSequence name = String.valueOf(Str.TMP.clear().add(¤¤name).insert(0, blue.info.names));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NobleOfficeUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */