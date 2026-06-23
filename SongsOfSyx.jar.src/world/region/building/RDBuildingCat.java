/*    */ package world.region.building;
/*    */ 
/*    */ import game.boosting.BValue;
/*    */ import game.faction.Faction;
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import java.util.Locale;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ public class RDBuildingCat
/*    */ {
/* 22 */   final ArrayListGrower<RDBuilding> all = new ArrayListGrower();
/*    */   
/*    */   public final COLOR color;
/*    */   public final String key;
/*    */   public final int order;
/*    */   
/*    */   RDBuildingCat(Creator creator, LISTE<RDBuilding> all, RD.RDInit init, String folder, PATHS.ResFolder p) throws IOException {
/* 29 */     this.key = folder.toUpperCase(Locale.ENGLISH);
/* 30 */     Json json = new Json(p.init.gets("_CAT"));
/* 31 */     this.color = (COLOR)new ColorImp(json);
/* 32 */     this.order = json.i("ORDER", 0, 10000000, 0);
/* 33 */     addJsons(creator, all, init, p);
/* 34 */     creator.generate(all, init, this, p);
/*    */     
/* 36 */     RDBuilding[] bus = new RDBuilding[this.all.size()];
/* 37 */     for (int i = 0; i < this.all.size(); i++)
/* 38 */       bus[i] = (RDBuilding)this.all.get(i); 
/* 39 */     this.all.clear();
/* 40 */     Arrays.sort(bus, new Comparator<RDBuilding>()
/*    */         {
/*    */           public int compare(RDBuilding o1, RDBuilding o2)
/*    */           {
/* 44 */             return o1.order.compareTo(o2.order);
/*    */           }
/*    */         });
/*    */     
/* 48 */     this.all.add((Object[])bus);
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<RDBuilding> all() {
/* 53 */     return (LIST<RDBuilding>)this.all;
/*    */   } private void addJsons(Creator creator, LISTE<RDBuilding> all, RD.RDInit init, PATHS.ResFolder p) throws IOException {
/*    */     byte b;
/*    */     int i;
/*    */     String[] arrayOfString;
/* 58 */     for (i = (arrayOfString = p.init.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 59 */       creator.read(all, init, this, f, p);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   
/* 64 */   static final BValue lValue = (BValue)new BValue.BValueNone()
/*    */     {
/*    */       public double vGet(Region reg) {
/* 67 */         return 1.0D;
/*    */       }
/*    */ 
/*    */       
/*    */       public double vGet(Faction f) {
/* 72 */         return 0.0D;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/* 78 */   static final BValue lGlobal = (BValue)new BValue.BValueNone()
/*    */     {
/*    */       public double vGet(Region reg) {
/* 81 */         return 1.0D;
/*    */       }
/*    */ 
/*    */       
/*    */       public double vGet(Faction f) {
/* 86 */         return 1.0D;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildingCat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */