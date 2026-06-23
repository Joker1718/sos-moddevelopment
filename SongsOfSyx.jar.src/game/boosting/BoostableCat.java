/*    */ package game.boosting;
/*    */ public class BoostableCat {
/*    */   public static final int TYPE_CRAP = 1;
/*    */   public static final int TYPE_WORLD = 2;
/*    */   public static final int TYPE_SETT = 4;
/*    */   public final String prefix;
/*    */   public final CharSequence name;
/*    */   public final CharSequence desc;
/*    */   public final SPRITE icon;
/*    */   public final int typeMask;
/*    */   
/*    */   public static final class All {
/*    */     public All() {
/* 14 */       this.WORLD_CIVICS = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 2, (SPRITE)(UI.icons()).s.world);
/* 15 */       this.WORLD_PRODUCTION = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 2, (SPRITE)(UI.icons()).s.world);
/* 16 */       this.WORLD = new BoostableCat("WORLD_", Dic.¤¤World, "", 2, (SPRITE)(UI.icons()).s.world);
/* 17 */       this.RELIGION = new BoostableCat("RELIGION_", BoostableCat.¤¤conversion, "", 6, (SPRITE)(UI.icons()).s.shrine);
/* 18 */       this.WORLD_DUMP = new BoostableCat("WORLD_", String.valueOf(Dic.¤¤World) + ": " + String.valueOf(Dic.¤¤World), "", 1, (SPRITE)(UI.icons()).s.world);
/*    */     }
/*    */ 
/*    */     
/*    */     public final BoostableCat WORLD_CIVICS;
/*    */     
/*    */     public final BoostableCat WORLD_PRODUCTION;
/*    */     public final BoostableCat WORLD;
/*    */     public final BoostableCat RELIGION;
/*    */     public final BoostableCat WORLD_DUMP;
/*    */   }
/*    */   
/* 30 */   ArrayListGrower<Boostable> all = new ArrayListGrower();
/* 31 */   private static CharSequence ¤¤conversion = "¤Conversion"; private static All al; public final BOOLEANO<BoostSpec> filter;
/*    */   static {
/* 33 */     D.ts(BoostableCat.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LIST<Boostable> all() {
/* 46 */     return (LIST<Boostable>)this.all;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static void init() {
/* 52 */     al = new All();
/*    */   }
/*    */   
/*    */   public static All ALL() {
/* 56 */     return al;
/*    */   }
/*    */   public BoostableCat(String prefix, CharSequence name, CharSequence desc, int typeMask, SPRITE icon) {
/* 59 */     this.filter = new BOOLEANO<BoostSpec>()
/*    */       {
/*    */         public boolean is(BoostSpec t)
/*    */         {
/* 63 */           return (t.boostable.cat == BoostableCat.this);
/*    */         }
/*    */       };
/*    */     this.prefix = prefix;
/*    */     this.name = name;
/*    */     this.desc = desc;
/*    */     this.typeMask = typeMask;
/*    */     this.icon = icon;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoostableCat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */